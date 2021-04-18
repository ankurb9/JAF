package com.web.seleniumEasy.test;

import static org.constants.variables.FrameworkConstants.*;

import java.net.MalformedURLException;

import org.constants.variables.ThreadConstants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.web.pageFactory.InputFormDemo;

import jaf.common.utility.ThreadConstantSetup;
import jaf.driver.utilities.JAFBase;

public class Input_Form_test  {
	InputFormDemo inputForm;

	String url = BASE_URL+"input-form-demo.html";
	private ThreadConstants tc ;
	
	@BeforeClass
	public void initTest() throws MalformedURLException {
		tc  = ThreadConstantSetup.get();
		new JAFBase().initWebDriver();
		inputForm = new InputFormDemo();
		tc.webDriver.get(url);
	}


	@Test
	public void validate_simple_input_form() {
		try {

			inputForm.enterValues("Ankur","Badamikar","test@gmail.com","745646546","Bhumkar","Pune");
			inputForm.submitForm();

		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}	
	
	
	@AfterClass
	public void quitDriver() {
		ThreadConstantSetup.get().webDriver.quit();
	}	

}
