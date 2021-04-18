package com.android.app.test;

import static jaf.common.utility.ThreadConstantSetup.get;

import org.enums.collection.LType;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.pagefactory.HomePage;

import jaf.common.utility.TC;
import jaf.driver.utilities.ADUtils;
import jaf.driver.utilities.JAFBase;

public class ScreenOperations_Test extends JAFBase{


	@Test
	public void validate_screenRotate() {
		try {

		
			new HomePage().click_views();

			get().androidDriver.navigate().back();
			System.out.println(get().androidDriver.getOrientation());
			TC.get().androidDriver.rotate(ScreenOrientation.LANDSCAPE);

		}catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test
	public void validate_ToggleButton() {
		try {

			ADUtils.getUIAutomator("text", "Preference").click();
			ADUtils.getUIAutomator("text", "9. Switch").click();
			ADUtils.getaElement(LType.xpath, "//android.widget.LinearLayout[@index='2']//android.widget.Switch").click();
			String text= ADUtils.getaElement(LType.xpath, "//android.widget.LinearLayout[@index='2']//android.widget.Switch").getAttribute("text");
			Assert.assertEquals(text, "ON");
		}catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}

	}


}
