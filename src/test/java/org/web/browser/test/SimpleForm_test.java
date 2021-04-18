package org.web.browser.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.web.pagefactory.pages.HomePage;
import org.web.pagefactory.pages.SimpleForm;

import jaf.common.utility.JAF;
import jaf.driver.utilities.JAFBase;

public class SimpleForm_test extends JAFBase{
	
	@BeforeMethod
	public void navigate() {
		
		try {
	
			HomePage.getWelcomNote();
			HomePage.getInputFormsLink();
			HomePage.gotoSimpleForm();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test()
	public void verify_Single_input_field() {
		try {
			
			
			String msg = "This is Java automation framework";
			SimpleForm.validateTitle();
			SimpleForm.messageBox().sendKeys(msg);
			SimpleForm.clickShowMesg();
			
			JAF.log("Validadating the text-->"+msg);
			//Assert.assertEquals(SimpleForm.getDisplaedMEssage(),msg);
			//Assert.fail("Failing this testcase");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
