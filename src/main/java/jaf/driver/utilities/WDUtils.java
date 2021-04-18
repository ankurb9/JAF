package jaf.driver.utilities;

import org.openqa.selenium.WebElement;

import static jaf.common.utility.TC.get;

import java.util.List;

import org.enums.collection.LType;

public class WDUtils {

	public static WebElement getwElement(LType lType, String locator) throws Exception {
		//JAF.log("Retruning web element with-->"+lType+"="+locator,true);
		return get().webDriver.findElement(DriverUtil.getByType(lType, locator));
		
	}
	
	public static List<WebElement> getwElements(LType lType, String locator) throws Exception {
		//JAF.log("Retruning web element with-->"+lType+"="+locator,true);
		return get().webDriver.findElements(DriverUtil.getByType(lType, locator));
		
	}
	
	

}
