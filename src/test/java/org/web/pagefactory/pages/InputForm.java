package org.web.pagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jaf.common.utility.TC;

public class InputForm {
	
	WebDriver driver;
	public InputForm() {
		PageFactory.initElements(TC.get().webDriver, this);
	}
	
	@FindBy(name = "first_name") WebElement fn;
	
	public WebElement fn() {
		return fn;
	}
	

}
