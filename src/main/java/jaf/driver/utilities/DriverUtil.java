package jaf.driver.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.constants.variables.ThreadConstants;
import org.enums.collection.LType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import jaf.common.utility.TC;
import jaf.common.utility.ThreadConstantSetup;

public class DriverUtil {

	public static By getByType(LType lType, String locator) throws Exception {

		switch (lType) {
		case id: 	return By.id(locator);
		case name:	return By.name(locator);
		case calssclassName:	return By.className(locator);
		case xpath: 	return By.xpath(locator);	
		case cssSelector: return By.cssSelector(locator);	
		case linkText:	return By.linkText(locator);	
		case partialLinkText: return By.partialLinkText(locator);
		case tagName: 	return By.tagName(locator);	
		case androidUIAutomator: return MobileBy.AndroidUIAutomator(locator);

		default:
			throw new Exception("Locator Type not found");
		}		
	}

	public static String getScreenShot() throws IOException {

		String ScreenShotPath = TC.get().logFolder+"\\ScreenShots\\"+getUniqueNumber()+".png";
		FileUtils.copyFile(((TakesScreenshot)TC.get().webDriver).getScreenshotAs(OutputType.FILE), new File(ScreenShotPath));
		return ScreenShotPath; 

	}

	public static String getUniqueNumber() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
		return df.format(date);
	}

	public static void setDriver() {
		ThreadConstants tc = ThreadConstantSetup.get();
		DriverSetup driverSetup = new DriverSetup();

		try {
			switch (tc.params.get("TestType").toLowerCase()) {
			case "web":
				driverSetup.setLocalDriver();
				break;
			case "saucelab":
				driverSetup.setRemoteDriver();
				break;
			case "androidApp":
				driverSetup.setMobileCapability();				
			default:
				Assert.fail("Test Type Not fund");
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}


}
