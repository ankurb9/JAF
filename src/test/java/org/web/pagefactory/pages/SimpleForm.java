package org.web.pagefactory.pages;

import org.enums.collection.LType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import jaf.common.utility.TC;
import jaf.driver.utilities.WDUtils;

public class SimpleForm {
	
	public static void validateTitle() {
		
		if(!TC.get().webDriver.getTitle().contains("Simple Form"))
			Assert.fail("Navigation unsuccessful");
			
		}
	
	public static WebElement messageBox() throws Exception {

		return WDUtils.getwElement(LType.xpath, "//input[@id='user-message']");

	}
	

	public static void clickShowMesg() throws Exception{

		WDUtils.getwElement(LType.xpath, "//button[text() = 'Show Message']").click();
	}

	public static String getDisplaedMEssage() throws Exception {

		return WDUtils.getwElement(LType.id, "display").getText();

	}

	public static WebElement getSum1() throws Exception {

		return WDUtils.getwElement(LType.id, "sum1");
	} 

	public static WebElement getSum2() throws Exception {

		return WDUtils.getwElement(LType.id, "sum2");
	} 
	
	public static void clickGetTotal() throws Exception{

		WDUtils.getwElement(LType.xpath, "//button[text() = 'Get Total']").click();
	}
	
	public static String getTotalVal() throws Exception {

		return WDUtils.getwElement(LType.id, "displayvalue").getText();

	}

}
