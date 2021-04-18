package com.android.app.test;

import org.enums.collection.LType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.android.pagefactory.HomePage;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static java.time.Duration.ofSeconds;

import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import jaf.driver.utilities.ADUtils;
import jaf.driver.utilities.DriverUtil;
import jaf.driver.utilities.JAFBase;

import static io.appium.java_client.touch.offset.ElementOption.*;
import static jaf.common.utility.TC.get;
import static jaf.driver.utilities.ADUtils.*;


public class TouchActions_test extends JAFBase{

	
	@BeforeMethod
	public void navigateToViews()  {
		try {
			
			HomePage.views();
			
		} catch (Exception e) {

			Assert.fail(e.getMessage());
			
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void validate_longPress() {
		
		TouchAction touchAction = new TouchAction(get().androidDriver);
		TapOptions tapOption = new TapOptions();
			
		tapOption = tapOption.withElement(element(ADUtils.getUIAutomator("text", "Expandable Lists")));
		touchAction.tap(tapOption).perform();
		
		tapOption = tapOption.withElement(element(ADUtils.getUIAutomator("text", "1. Custom Adapter")));
		touchAction.tap(tapOption).perform();
		
		touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(ADUtils.getUIAutomator("text", "People Names"))).withDuration(ofSeconds(2))).release().perform();
		
		Boolean val = ADUtils.getaElement(LType.id, "android:id/title").isDisplayed();
		
		Boolean exp = true;
		Assert.assertEquals(val,exp);
	
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void validate_swipeActions() throws InterruptedException {
		
	
		TouchAction touchAction = new TouchAction(get().androidDriver);
		
		TapOptions tapOption = new TapOptions();
			
		tapOption = TapOptions.tapOptions().withElement(element(ADUtils.getUIAutomator("text", "Date Widgets")));
		touchAction.tap(tapOption).perform();
		
		tapOption = tapOption.withElement(element(ADUtils.getUIAutomator("text", "2. Inline")));
		touchAction.tap(tapOption).perform();
		
		ADUtils.getaElement(LType.xpath, "//*[@content-desc='9']").click();
		
		LongPressOptions longPress1 = longPressOptions().withElement(element(getaElement(LType.xpath, "//*[@content-desc='15']"))).withDuration(ofSeconds(2));
		
		touchAction.longPress(longPress1).moveTo(element(getaElement(LType.xpath, "//*[@content-desc='45']"))).release().perform();
		
		Thread.sleep(5000);
				
	}
	
	@Test
	public void validate_ScrollToElement() {
		
		String uiSelector1 = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))";
		String uiSelector2 = "new UiScrollable(new UiSelector()).scrollTextIntoView(\"Search View\")";
		
		try {
			get().androidDriver.findElement(DriverUtil.getByType(LType.androidUIAutomator, uiSelector2));
			Thread.sleep(3000);
			get().androidDriver.findElement(DriverUtil.getByType(LType.androidUIAutomator, uiSelector1));
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
			
	}
	
	@Test
	public void validate_ScrollToElement_CoOrdinate() {
		
		
		
		try {
			
			
			TouchAction ta = new TouchAction(get().androidDriver);
			
	
			
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
			
	}
	
	@AfterMethod
	public void TearDown() {
		get().androidDriver.quit();
		System.out.println("Closed");
	}
}
