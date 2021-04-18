package org.listner.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.constants.variables.FrameworkConstants;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

public class ReportListner implements IReporter{

	public void generateReport(
			List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		if(FrameworkConstants.LOGGING) {
			String src = outputDirectory+"\\emailable-report.html";
			String dest = System.getProperty("user.dir")+"\\Automation-Output\\"+FrameworkConstants.LOG_ROOT;

			try {
				FileUtils.copyFileToDirectory(new File(src), new File(dest));
				System.out.println(dest+"\\emailable-report.html");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
