package jaf.setup.listner;

import static org.constants.variables.FrameworkConstants.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class JAFSetupListner2 implements ITestListener,ISuiteListener{

	static Map<String, ExtentReports> extent = new HashMap<String, ExtentReports>();
	static Map<String, String> logfolder  = new HashMap<String, String>();

	public static int ThreadId = 0;

	public void onStart(ISuite suite) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("ddMMyyyy-HHmmss_SSS");
		LOG_ROOT = df.format(date);
	}
	
	public void onStart(ITestContext context) {

		String report = context.getCurrentXmlTest().getParameter("ExtentReporting");
		if(report!=null)
			extentReporting = Boolean.valueOf(report);

		String logging = context.getCurrentXmlTest().getParameter("Logging");
		if(logging!=null)
			LOGGING = Boolean.valueOf(logging);

		if(extentReporting) {
			String logFolder = System.getProperty("user.dir")+"\\Automation-Output\\"+LOG_ROOT+"\\"+context.getName();

			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(logFolder+"\\JAF_Report.html");

			ExtentReports extent = new ExtentReports();

			try {
			    htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\main\\resources\\Configurations\\HTMLReporter.xml");
			} catch (IOException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}

			extent.attachReporter(htmlReporter);

			this.extent.put(context.getName(), extent);
			this.logfolder.put(context.getName(), logFolder);
			
		}
		
	}

	public void onFinish(ITestContext context) {
		if(extent.containsKey(context.getName()))
			extent.get(context.getName()).flush();
	}

	



}
