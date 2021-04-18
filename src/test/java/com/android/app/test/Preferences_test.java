package com.android.app.test;

import org.constants.variables.ThreadConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.android.pagefactory.HomePage;
import com.android.pagefactory.Preferences;
import com.android.pagefactory.PreferenceDependencies;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

import static jaf.common.utility.ThreadConstantSetup.get;

import java.net.URL;

public class Preferences_test {


	@BeforeMethod
	public void init()  {
		try {

			ThreadConstants tc = get();
			tc.androidDriver = new AppiumDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), tc.desiredCapabilities);

			new HomePage().click_preferences();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void wifiSetting() {
		try {
			Preferences preferences = new Preferences();
			preferences.click_preferenceDependencies();

			PreferenceDependencies preferenceDependencies = new PreferenceDependencies();
			preferenceDependencies.click_wifiCheckbox();
			preferenceDependencies.click_wiFiSettings();
			preferenceDependencies.type_wifiSettingText("Ankur");
			preferenceDependencies.click_okButton();
			Thread.sleep(5000);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}


}
