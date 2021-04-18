package org.trial.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class WebDriverTest {
	
	@Test
	public void wdTest() throws ClassNotFoundException {
		
		ExtentReports extent = new ExtentReports();
		String str = extent.toString();
		
		System.out.println(str);
		Class c = Class.forName("str"); 
		
		
		
	}

}
