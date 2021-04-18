package jaf.common.utility;

import java.io.IOException;

import org.constants.variables.FrameworkConstants;
import org.enums.collection.logLevel;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import jaf.driver.utilities.DriverUtil;

public class JAF {

	public static  void log(Object msg)  {
		
		
		try {
		if(FrameworkConstants.LOGGING) 
			Reporter.log(msg.toString(), true);

		if(ThreadConstantSetup.get().extentTest!=null)
			TC.get().extentTest.log(Status.INFO,msg.toString());
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void log(String msg, boolean takeScreenShot) throws IOException {
		
		
		String link = DriverUtil.getScreenShot();
		String hyperlink = "<a href=\"#\"\r\n" + 
				"  target=\"popup\" \r\n" + 
				"  onclick=\"window.open('"+link.replace("\\", "//")+"','popup','width=600,height=600'); return false;\"> Screen Shot" + "</a>";
		//String hyperlink = "<img src=\""+link+"\">";
		Reporter.log(msg+": "+hyperlink, false);
		//System.out.println(msg);

		if(TC.get().extentTest!=null)
			TC.get().extentTest.log(Status.INFO,msg +": "+hyperlink);

	}





}
