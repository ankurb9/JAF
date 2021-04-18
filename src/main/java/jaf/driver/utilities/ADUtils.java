package jaf.driver.utilities;

import java.util.List;

import org.enums.collection.LType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.appium.java_client.android.AndroidElement;
import jaf.common.utility.TC;

public class ADUtils {

	public static AndroidElement getaElement(LType lType, String locator)  {

		try {
			
		
			return (AndroidElement) TC.get().androidDriver.findElement(DriverUtil.getByType(lType, locator));
		} catch (Exception e) {
			Assert.fail(lType.toString()+"="+locator+"-->failed with EXCEPTION = "+e.getMessage());

			e.printStackTrace();
			return null;

		}
	}
	
	public static WebElement getElement(LType lType, String locator)  {

		try {
			return TC.get().androidDriver.findElement(DriverUtil.getByType(lType, locator));
		} catch (Exception e) {
			Assert.fail(lType.toString()+"="+locator+"-->failed with EXCEPTION = "+e.getMessage());

			e.printStackTrace();
			return null;

		}
	}

	public static AndroidElement getUIAutomator(String attribute, String value)  {

		try {				
			return (AndroidElement) TC.get().androidDriver.findElement(DriverUtil.getByType(LType.androidUIAutomator, attribute+"(\""+value+"\")"));
		} catch (Exception e) {
			Assert.fail(attribute+"="+value+"-->failed with EXCEPTION = "+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public static List<AndroidElement> getUIAutomators(String attribute, String value)  {

		try {				
			return TC.get().androidDriver.findElements(DriverUtil.getByType(LType.androidUIAutomator, "new UiSelector()."+attribute+"(\""+value+"\")"));
		} catch (Exception e) {
			Assert.fail(attribute+"="+value+"-->failed with EXCEPTION = "+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static List<AndroidElement> uiAutomators(String attribute, Boolean value)  {

		try {				
			return TC.get().androidDriver.findElements(DriverUtil.getByType(LType.androidUIAutomator, "new UiSelector()."+attribute+"("+value+")"));
		} catch (Exception e) {
			Assert.fail(attribute+"="+value+"-->failed with EXCEPTION = "+e.getMessage());
			e.printStackTrace();
			return null;
		}



	}

}
