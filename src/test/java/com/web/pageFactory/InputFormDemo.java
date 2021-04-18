package com.web.pageFactory;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jaf.common.utility.ThreadConstantSetup;

public class InputFormDemo {
		
	public InputFormDemo() {
		
		PageFactory.initElements(ThreadConstantSetup.get().ajaxElementLocatorFactory, this);		
	} 
	
	@FindBy(name = "first_name") WebElement iFN;
	@FindBy(name = "last_name") WebElement iLN;
	@FindBy(name = "email") WebElement iEmail;
	@FindBy(name = "phone") WebElement iphone;
	@FindBy(name = "address") WebElement iAddress;
	@FindBy(name = "city") WebElement iCity;	
	@FindBy(xpath = "//button[text() = 'Send ']") WebElement bSubmit;
	
	public void enterValues(String...input) {
		
		iFN.sendKeys(input[0]);
		iLN.sendKeys(input[1]);
		iEmail.sendKeys(input[2]);
		iphone.sendKeys(input[3]);
		iAddress.sendKeys(input[4]);
		iCity.sendKeys(input[5]);
	}
	
	public void submitForm() {
		bSubmit.click();
	}
}
