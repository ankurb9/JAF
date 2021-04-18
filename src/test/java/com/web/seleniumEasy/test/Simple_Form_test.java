package com.web.seleniumEasy.test;

import static org.constants.variables.FrameworkConstants.*;

import java.net.MalformedURLException;

import org.constants.variables.ThreadConstants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.pageFactory.SimpleFormDemo;

import jaf.common.utility.ThreadConstantSetup;
import jaf.driver.utilities.JAFBase;

public class Simple_Form_test {


	final String val = "My rame is Ankur" ;
	SimpleFormDemo simpleForm;
	private String url = BASE_URL+"basic-first-form-demo.html";
	private ThreadConstants tc ;
	
	public Simple_Form_test() {}
	
	@BeforeClass
	public void initTest() throws MalformedURLException {
		tc  = ThreadConstantSetup.get();
		new JAFBase().initWebDriver();
		tc.webDriver.get(url);
		simpleForm = new SimpleFormDemo();
		
	}
	
	

	@Test
	public void validate_simple_input_form() {
		try {			 
			simpleForm.input_msgBox(val);
			simpleForm.button_showMsg();
			simpleForm.label_validateMsg(val);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void validate_Two_Input_Fields_test(){
		try {
			SimpleFormDemo simpleForm = new SimpleFormDemo();
			simpleForm.enterNumbers(3,4);
			simpleForm.clickGetTotal();
			simpleForm.validateTotal(3+4);

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
