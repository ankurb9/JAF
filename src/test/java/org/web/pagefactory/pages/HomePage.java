package org.web.pagefactory.pages;

import org.enums.collection.LType;
import org.testng.Assert;

import jaf.driver.utilities.WDUtils;

public class HomePage {
	String var;
	public HomePage(){
		
	}
	
	public static void getWelcomNote() throws Exception {

		String welcomeNote= WDUtils.getwElement(LType.xpath, "//div[@id='home']/h3").getText();
		Assert.assertEquals(welcomeNote.toUpperCase(), "WELCOME TO SELENIUM EASY DEMO");
		
	}
	
	
	
	public static void getInputFormsLink() throws Exception{
		WDUtils.getwElement(LType.xpath, "//*[text()='Input Forms']").click();
	}
	
	public static void gotoSimpleForm() throws Exception{		
		WDUtils.getwElement(LType.xpath, "//*[@id='treemenu']/li/ul/li[1]/ul/li[1]/a").click();
		}

}
