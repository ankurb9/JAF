package org.arg.testNG.runner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class TestNGRunner {

	final static int users = 1000;

	public static void main(String[] args) throws InterruptedException {
		TestNGRunner tng = new TestNGRunner();
		tng.runxmlSuit();

	}

	public void threading() throws InterruptedException {

		int val = excelData().size();

		List<Thread> threadList= new ArrayList<Thread>();

		List<Map<String,String>> exceldata = new ArrayList<Map<String,String>>();

		for (final Map<String,String> excelmap : exceldata) {

			Thread thread = new Thread()  {
				public void run() {
					System.err.println(excelmap);
					TestNGRunner ng = new TestNGRunner();
					ng.runxmlSuit(excelmap);

				}
			};
			thread.start();
			//threadList.add(thread);
		} 

		/*
		 * for( Thread t:threadList) t.start();
		 * 
		 * for( Thread t:threadList) t.join();
		 */

	}

	public void runxmlSuit(Map<String,String> map) {


		XmlSuite suite = new XmlSuite();
		suite.setName("Suit");

		List<String> listners = new ArrayList<String>();
		listners.add("org.listner.utilities.TestSetupListner");

		suite.setListeners(listners);
		XmlTest xmlTest = null ;
		
		for(int i=0;i<=users;i++) {
			xmlTest= new XmlTest(suite);
			xmlTest.setName("Test"+i);
			xmlTest.addParameter("TestType", "local");
			xmlTest.addParameter("Device", "web");
			xmlTest.addParameter("Browser", "html");
			xmlTest.addParameter("Reporting", "false");

		}
		
		for(Map.Entry<String, String> entry : map.entrySet())
			xmlTest.addParameter(entry.getKey().toString(), entry.getValue().toString());

		XmlClass cls = new XmlClass("org.remote.browser.test.SampleSauceLab");

		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(cls);

		xmlTest.setXmlClasses(classes);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);

		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);

		tng.run();


	} 

	public List<Map<String, String>> excelData() {

		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		Map<String, String> eMap = new HashMap<String, String>();
		eMap.put("OS", "Windows 10");
		eMap.put("Browser", "Chrome");
		eMap.put("TestType", "SauceLab");

		Map<String, String> eMap1 = new HashMap<String, String>();
		eMap1.put("OS", "Windows 10");
		eMap1.put("Browser", "Firefox");
		eMap1.put("TestType", "SauceLab");

		listMap.add(eMap);
		listMap.add(eMap1);

		return listMap;
	}
	
	public void runxmlSuit() {

		XmlSuite suite = new XmlSuite();
		suite.setName("Suit");
		suite.setParallel(ParallelMode.TESTS);
		suite.setThreadCount(users);
		

		List<String> listners = new ArrayList<String>();
		listners.add("org.listner.utilities.TestSetupListner");

		suite.setListeners(listners);
		XmlTest xmlTest = null ;
		
		for(int i=0;i<users;i++) {
			xmlTest= new XmlTest(suite);
			xmlTest.setName("Test"+i);
			xmlTest.addParameter("TestType", "local");
			xmlTest.addParameter("Device", "web");
			xmlTest.addParameter("App", "phantomjs");
			xmlTest.addParameter("Reporting", "false");
			
			XmlClass cls = new XmlClass("org.web.browser.test.SimpleForm_test");

			List<XmlClass> classes = new ArrayList<XmlClass>();
			classes.add(cls);

			xmlTest.setXmlClasses(classes);

		}
		
		
		
		  List<XmlSuite> suites = new ArrayList<XmlSuite>(); 
		  suites.add(suite);
		  
		  TestNG tng = new TestNG(); 
		  tng.setXmlSuites(suites);
		  
		  long dm1 = getDate();
		  tng.run(); 
		  long dm2 = getDate();
		  
		  System.out.println("Total time taken-->"+ (dm2-dm1));
	} 
	
	long getDate()  {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("ddMMyyyy-HHmmss_SSS");
		long dm = date.getTime();
		return dm;
		
		
	}


}
