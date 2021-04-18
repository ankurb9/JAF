package com.android.app.test;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.android.pagefactory.HomePage;

import jaf.common.utility.JAF;
import jaf.driver.utilities.ADUtils;
import jaf.driver.utilities.JAFBase;

public class Views extends JAFBase{
	
	@BeforeMethod
	public void navigateToViews()  {
		try {
			HomePage.views();
		} catch (Exception e) {

			Assert.fail(e.getMessage());
			
		}
	}
	
	@Test
	public void validate_index_count() {
		int size = ADUtils.uiAutomators("clickable", false).size();
		Assert.assertEquals(size, 12);
		
	}

}
