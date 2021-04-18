package jaf.setup.listner;

import static jaf.setup.listner.JAFSetupListner2.*;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import jaf.common.utility.ThreadConstantSetup;

public class JAFThreadConfiguration  implements IInvokedMethodListener {
	
	public void beforeInvocation(
			IInvokedMethod method, ITestResult testResult, ITestContext context) {		
			
		
		if(ThreadConstantSetup.get() ==null) {
			
			ThreadConstantSetup.get().params = context.getCurrentXmlTest().getAllParameters();

			if(extent.containsKey(context.getName()) && ThreadConstantSetup.get().extentReports==null) {
				ThreadConstantSetup.get().extentReports = extent.get(context.getName());
				ThreadConstantSetup.get().logFolder = logfolder.get(context.getName());
			}
		}

		if(method.isTestMethod() && ThreadConstantSetup.get().extentReports!=null) {
			
			ThreadConstantSetup.get().extentTest = ThreadConstantSetup.get().extentReports.createTest(method.getTestMethod().getInstance().getClass().getSimpleName() +"-"+method.getTestMethod().getMethodName());
		}
		

	}
	
	

}
