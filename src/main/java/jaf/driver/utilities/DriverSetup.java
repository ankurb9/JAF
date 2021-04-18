package jaf.driver.utilities;

import static jaf.common.utility.ThreadConstantSetup.get;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.constants.variables.ThreadConstants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import io.appium.java_client.remote.MobileCapabilityType;



public class DriverSetup {
	private ThreadConstants tc;
	
	public DriverSetup() {
		tc= get();
	}
	
	
	public void setLocalDriver() {	
		
		switch (tc.params.get("Browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
			tc.webDriver  = new ChromeDriver();			
			tc.webDriver .manage().window().maximize();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\geckodriver.exe");
			tc.webDriver = new FirefoxDriver();
			tc.webDriver .manage().window().maximize();
			break;
		default:
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\phantomjs.exe");
			tc.webDriver  = new PhantomJSDriver(capabilities);			
			tc.webDriver .manage().window().maximize();
			break;
		}
		
		tc.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		tc.ajaxElementLocatorFactory = new AjaxElementLocatorFactory(tc.webDriver, 10);
		
		
	}

	public void setRemoteDriver() throws MalformedURLException {

		String sauceUserName = "SauceLab1806";
		String sauceAccessKey = "dba1f5f3-dffd-41b3-b002-084f62781fd7";

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("username", sauceUserName);
		capabilities.setCapability("accessKey", sauceAccessKey);
		capabilities.setCapability("browserName", tc.params.get("Browser"));
		capabilities.setCapability("platform", tc.params.get("OS"));  

		Date date = new Date();
		long timeMilli = date.getTime();
		capabilities.setCapability("name", timeMilli);

		tc.webDriver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), capabilities);
		tc.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		tc.webDriver.manage().window().maximize();
		((RemoteWebDriver)tc.webDriver).setFileDetector(new LocalFileDetector());

	}

	public void setMobileDriver(String appName) {
		String platform = "";;

		if(tc.params.get("App").contains(".apk"))
			platform = "android";

		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Android_Apps\\"+appName);

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, tc.params.get("DeviceName"));
		cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
		tc.desiredCapabilities= cap;

	}
	
	public void setMobileCapability() {
		String platform = "";;

		if(tc.params.get("App").contains(".apk"))
			platform = "android";

		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Android_Apps\\"+tc.params.get("App"));

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, tc.params.get("DeviceName"));
		cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
		tc.desiredCapabilities= cap;

	}
	
	
	
}
