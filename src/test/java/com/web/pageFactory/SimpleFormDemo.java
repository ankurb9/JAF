package com.web.pageFactory;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import jaf.common.utility.ThreadConstantSetup;

public class SimpleFormDemo {
	
	public SimpleFormDemo() {
		
		PageFactory.initElements(ThreadConstantSetup.get().ajaxElementLocatorFactory, this);		
	}
	
	@FindBy(xpath = "//input[@id = 'user-message']") WebElement input_msgBox;
	@FindBy(id = "display") WebElement label_validateMsg;
	@FindBy(xpath = "//button[text() = 'Show Message']") WebElement button_showMsg;
	@FindBy(id = "sum1") WebElement input_sum1;
	@FindBy(id = "sum2") WebElement input_sum2;
	@FindBy(xpath="//button[text() = 'Get Total']") WebElement button_getTotla;
	@FindBy(id="displayvalue") WebElement label_validateTotla;
	
	public void input_msgBox(String str) {
		input_msgBox.sendKeys(str);
	}
	
	public void button_showMsg() throws InterruptedException {
		
		button_showMsg.click();
	}
		
	public void label_validateMsg(String str) {
		Assert.assertEquals(label_validateMsg.getText(), str);
	}
	
	public void enterNumbers(int...num) {
		input_sum1.sendKeys(String.valueOf(num[0]));
		input_sum2.sendKeys(String.valueOf(num[1]));
	}
	
	public void clickGetTotal() throws InterruptedException {
			button_getTotla.click();
	}
	
	public void validateTotal(int total) {
		Assert.assertEquals(Integer.parseInt(label_validateTotla.getText()), total);
	}
	

}
