package org.listner.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.api.uitils.HTTPCommunication;
import org.springframework.context.annotation.Primary;
import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestNGListenerFactory;
import org.testng.ITestResult;
import org.testng.internal.ITestInvoker;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import jaf.common.utility.TC;
import jaf.driver.utilities.DriverSetup;

public class TestSetupListner implements IClassListener,ITestListener,ISuiteListener{


	Map<String, ExtentReports> extent = new HashMap<String, ExtentReports>();
	Map<String, String> logfolder  = new HashMap<String, String>();

	public static String logRoot;

	public void onStart(ISuite suite) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("ddMMyyyy-HHmmss_SSS");
		logRoot = df.format(date);
	}


	public void onStart(ITestContext context) {

		if(!context.getCurrentXmlTest().getParallel().toString().equals("classes"))
			TC.initThreadPool();

		boolean reporting = true;

	
			String report = context.getCurrentXmlTest().getParameter("Reporting");
			if(report!=null)
				reporting = Boolean.valueOf(report);

		

		if(reporting) {
			String logFolder = System.getProperty("user.dir")+"\\Automation-Output\\"+logRoot+"\\"+context.getName();

			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(logFolder+"\\JAF_Report.html");

			ExtentReports extent = new ExtentReports();

			try {
			    htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\main\\resources\\Configurations\\HTMLReporter.xml");
			} catch (IOException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}

			extent.attachReporter(htmlReporter);

			this.extent.put(context.getName()+"_extent", extent);
			this.logfolder.put(context.getName()+"_logFolder", logFolder);

		}
	}

	public void onFinish(ITestContext context) {
		if(extent.containsKey(context.getName()+"_extent"))
			extent.get(context.getName()+"_extent").flush();
	}

	public void onBeforeClass(ITestClass testClass) {
		
		if(testClass.getXmlTest().getParallel().toString().equals("classes"))
			TC.initThreadPool();
		
		if(extent.containsKey(testClass.getXmlTest().getName()+"_extent")) {
			TC.get().extentReports = extent.get(testClass.getXmlTest().getName()+"_extent");
			TC.get().logFolder = this.logfolder.get(testClass.getXmlTest().getName()+"_logFolder");
		}
		
		TC.get().params = testClass.getXmlTest().getAllParameters();

		DriverSetup ds = new DriverSetup();

		

	}

	public void onAfterClass(ITestClass testClass) {
			if(TC.get().webDriver!=null)
				TC.get().webDriver.quit();
	}

	public void onTestSuccess(ITestResult result) {
		if(TC.get().extentTest!=null)
		TC.get().extentTest.log(Status.PASS, result.getMethod().getMethodName()+" has Passed \n");
	}

	public void onTestFailure(ITestResult result) {
		if(TC.get().extentTest!=null)
		TC.get().extentTest.log(Status.FAIL, result.getMethod().getMethodName()+" has failed \n"+result.getThrowable().getMessage().toString());
	}




}
