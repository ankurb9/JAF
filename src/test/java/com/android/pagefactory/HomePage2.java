package com.android.pagefactory;

import static jaf.common.utility.ThreadConstantSetup.get;

import org.enums.collection.LType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidBy;
import jaf.common.utility.JAF;
import jaf.driver.utilities.ADUtils;

public class HomePage2 {
	
	
	public HomePage2() {
		
		PageFactory.initElements(get().ajaxElementLocatorFactory, this);
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Preference']") WebElement preferences;
	public void click_preferences() {
		preferences.click();
	}
	
	@AndroidBy(uiAutomator = "text(\"Views\")") WebElement views;
	public void click_views() {
		views.click();
	}

	public static void preferences() throws Exception {
		ADUtils.getaElement(LType.xpath, "//android.widget.TextView[@text='Preference']").click();
		JAF.log("Moved to preferences page");
	}
	
	public static void views() throws Exception {
		ADUtils.getUIAutomator("text", "Views").click();
		JAF.log("Moved to preferences page");
	}
	

	


}
