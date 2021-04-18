package com.android.pagefactory;

import static jaf.common.utility.ThreadConstantSetup.get;

import org.constants.variables.ThreadConstants;
import org.enums.collection.LType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jaf.driver.utilities.ADUtils;

public class PreferenceDependencies {
	ThreadConstants tc;
	
	public PreferenceDependencies() {
		 tc = get();
		 PageFactory.initElements(tc.ajaxElementLocatorFactory, this);
		
	}
	
	@FindBy(id = "android:id/checkbox") WebElement wifiCheckbox;
	public void click_wifiCheckbox() {
		wifiCheckbox.click();	
	}
	
	@FindBy(xpath = "(//android.widget.RelativeLayout)[2]") WebElement wiFiSettings;
	public void click_wiFiSettings() {
		wiFiSettings.click();
	}
	
	@FindBy(id = "android:id/edit") WebElement wifiSettingText;
	public void type_wifiSettingText(String text) {
		wifiSettingText.sendKeys(text);
		
	}
	
	@FindBy(xpath = "//*[@text='OK']") WebElement okButton;
	public void click_okButton() {
		okButton.click();
	}
	
	
	public static void wifiCheckbox() {
		
		ADUtils.getaElement(LType.id, "android:id/checkbox").click();
	}
	
	public static void wiFiSettings()  {
		ADUtils.getaElement(LType.xpath, "(//android.widget.RelativeLayout)[2]").click();
	}
	
	public static void wifiSettingText(String text)  {
		ADUtils.getaElement(LType.id, "android:id/edit").sendKeys(text);
	}
	
	public static void okButton() {
		ADUtils.getaElement(LType.xpath, "//*[@text='OK']");
	}

}
