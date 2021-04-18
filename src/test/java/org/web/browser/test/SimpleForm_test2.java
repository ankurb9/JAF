package org.web.browser.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.web.pagefactory.pages.HomePage;
import org.web.pagefactory.pages.SimpleForm;

import com.aventstack.extentreports.Status;

import jaf.common.utility.JAF;
import jaf.common.utility.TC;
import jaf.driver.utilities.JAFBase;

public class SimpleForm_test2 extends JAFBase{

	@BeforeMethod
	public void navigate() throws Exception{
		try {
		
			HomePage.getWelcomNote();
			HomePage.getInputFormsLink();
			HomePage.gotoSimpleForm();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void verify_TwoInputFields() throws Exception{


		String sum1 ="4";
		String sum2 = "8";
		String Total = String.valueOf(Integer.valueOf(sum1) + Integer.valueOf(sum2));

		SimpleForm.validateTitle();
		SimpleForm.getSum1().sendKeys(sum1);
		SimpleForm.getSum2().sendKeys(sum2);
		SimpleForm.clickGetTotal();
		Thread.sleep(2000);
		JAF.log("Validadating the Numbe-->"+Total);
		Assert.assertEquals(SimpleForm.getTotalVal(),Total);


	}

}
