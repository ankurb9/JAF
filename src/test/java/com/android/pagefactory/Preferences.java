package com.android.pagefactory;

import static jaf.common.utility.ThreadConstantSetup.get;

import org.enums.collection.LType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jaf.driver.utilities.ADUtils;

public class Preferences {
	public Preferences(){
		PageFactory.initElements(get().ajaxElementLocatorFactory, this);
	}
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Preference dependencies')]") WebElement preferenceDependencies;
	public void click_preferenceDependencies() {
		preferenceDependencies.click();
	}
	
	public static void preferenceDependencies() throws Exception {
		
		ADUtils.getaElement(LType.xpath, "//android.widget.TextView[contains(@text,'Preference dependencies')]").click();
		
	}

}
