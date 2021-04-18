package org.listner.utilities;

import static org.constants.variables.FrameworkConstants.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.IClassListener;
import org.testng.IConfigurationListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.internal.IMethodRunner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import jaf.common.utility.TC;

public class JAFSetupListner implements IClassListener,ITestListener,ISuiteListener{


	Map<String, ExtentReports> extent = new HashMap<String, ExtentReports>();
	Map<String, String> logfolder  = new HashMap<String, String>();


	public void onStart(ISuite suite) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("ddMMyyyy-HHmmss_SSS");
		LOG_ROOT = df.format(date);
	}


	public void onStart(ITestContext context) {

		//		if(!context.getCurrentXmlTest().getParallel().toString().equals("classes"))
		//			TC.initThreadPool();

		String report = context.getCurrentXmlTest().getParameter("ExtentReporting");
		if(report!=null)
			extentReporting = Boolean.valueOf(report);

		String logging = context.getCurrentXmlTest().getParameter("Logging");
		if(logging!=null)
			LOGGING = Boolean.valueOf(logging);

		if(extentReporting)
		    try {
			
			    
			    	String logFolder = System.getProperty("user.dir")+"\\Automation-Output\\"+LOG_ROOT+"\\"+context.getName();

			    	ExtentSparkReporter htmlReporter = new ExtentSparkReporter(logFolder+"\\JAF_Report.html");

			    	ExtentReports extent = new ExtentReports();

			    
			    	    htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\main\\resources\\Configurations\\HTMLReporter.xml");
			    	
			    	extent.attachReporter(htmlReporter);

			    	this.extent.put(context.getName(), extent);
			    	this.logfolder.put(context.getName(), logFolder);

			
			
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
	}

	public void onFinish(ITestContext context) {
		if(extent.containsKey(context.getName()))
			extent.get(context.getName()).flush();
	}

	public void onBeforeClass(ITestClass testClass) {
		//if(testClass.getXmlTest().getParallel().toString().equals("classes"))
		TC.initThreadPool();

		if(extent.containsKey(testClass.getXmlTest().getName())) {
			TC.get().extentReports = extent.get(testClass.getXmlTest().getName());
			TC.get().logFolder = this.logfolder.get(testClass.getXmlTest().getName());
		}

		TC.get().params = testClass.getXmlTest().getAllParameters();		

	}
	 
	
}
