package org.arg.testNG.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class TestNGRunner1 {
	int i= 0;

	public static void main(String[] args) throws InterruptedException {
		new TestNGRunner1().xmlSuit();
	}

	/*
	 * public void threading() throws InterruptedException {
	 * 
	 * int val = excelData().size();
	 * 
	 * List<Thread> threadList= new ArrayList<Thread>();
	 * 
	 * for (final Map<String,String> excelmap : excelData()) {
	 * 
	 * Thread thread = new Thread() { public void run() {
	 * 
	 * List<XmlSuite> suites = new ArrayList<XmlSuite>();
	 * suites.add(xmlSuit(excelmap));
	 * 
	 * TestNG tng = new TestNG();
	 * 
	 * tng.setXmlSuites(suites); tng.run();
	 * 
	 * } }; threadList.add(thread); //thread.run(); }
	 * 
	 * for( Thread t:threadList) {
	 * 
	 * t.start(); }
	 * 
	 * for( Thread t:threadList) {
	 * 
	 * t.join(); }
	 * 
	 * }
	 */

	public XmlSuite xmlSuit() {
		
		XmlSuite suite = new XmlSuite();
		suite.setName("Suit");
		suite.setThreadCount(10);
		suite.setParallel(ParallelMode.TESTS);
		List<String> listeners = new ArrayList<String>();
		listeners.add("org.init.setup.SetupListner2");
		
		suite.setListeners(listeners);
	
		List<Map<String, String>> excelmap = excelData();
		
		for(Map<String, String> map : excelmap) {
			XmlTest xmlTest = new XmlTest(suite);
			xmlTest.setName("Test"+i++);
			xmlTest.setParallel(ParallelMode.TESTS);

			for(Map.Entry<String, String> me : map.entrySet())
				xmlTest.addParameter(me.getKey().toString(), me.getValue().toString());
			
			List<XmlClass> classes = new ArrayList<XmlClass>();

			classes.add(new XmlClass("org.trial.test.SimpleForm_test"));
			classes.add(new XmlClass("org.trial.test.SimpleForm_test2"));

			xmlTest.setXmlClasses(classes);
		}
		
		System.out.println(suite.toXml().toString());
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		
		suites.add(suite);
		
		List<Class> listnerClasses = new ArrayList<Class>();
		

		TestNG tng = new TestNG();

		tng.setXmlSuites(suites);
		tng.run();


		return suite;
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
		eMap.put("TestType", "SauceLab");

		listMap.add(eMap);
		listMap.add(eMap1);

		return listMap;
	}



}
