package org.constants.variables;

import java.util.Map;

import org.api.uitils.HTTPCommunication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class ThreadConstants {		
	
	public boolean threadPoolInitialised = false; //never disturb this variable 
	public String logFolder;
	public String browser;
	public String os;
	public WebDriver webDriver;
	public String testType;	
	public ExtentTest extentTest;
	public ExtentReports extentReports = null;
	public Map<String, String> params;	
	public AppiumDriver<AndroidElement> androidDriver;
	public DesiredCapabilities desiredCapabilities;
	public HTTPCommunication httpCommunication;
	public boolean logging;
	public AjaxElementLocatorFactory ajaxElementLocatorFactory;
	public String APIName = "";
	public String test = "";
	public String class1 = "";
	

}
