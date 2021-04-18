package jaf.driver.utilities;

import java.io.IOException;
import java.lang.reflect.Method;
import org.constants.variables.ThreadConstants;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import jaf.common.utility.ThreadConstantSetup;

public class JAFBase {

	static ExtentReports extent;
	String TestType = "";
	String Browser = "";
	String OS = "";
	public ThreadConstantSetup get;
	public ThreadConstants tc;

	@BeforeClass
	public void b4Class() {
		tc= ThreadConstantSetup.get();
		tc.class1 = "b4Class";
		System.out.println("b4Class: "+Thread.currentThread().getId());
	}
	
	
	@BeforeTest
	public void b4Test() {
		tc= ThreadConstantSetup.get();
		tc.test = "b4Test";
		System.out.println("b4Test: "+Thread.currentThread().getId());
	}
	
	@BeforeMethod
	public void b4Method() {
		tc = ThreadConstantSetup.get();
		tc.APIName = "b4Method";
		System.out.println("b4Method: "+Thread.currentThread().getId());
	}

	public void initWebDriver()  {
		DriverSetup driverSetup = new DriverSetup();

		try {

			switch (ThreadConstantSetup.get().params.get("TestType").toLowerCase()) {
			case "web":
				driverSetup.setLocalDriver();
				break;
			case "saucelab":
				driverSetup.setRemoteDriver();
				break;
			default:
				Assert.fail("Test Type Not fund");
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

}









