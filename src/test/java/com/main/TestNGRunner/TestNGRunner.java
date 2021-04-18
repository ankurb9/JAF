package com.main.TestNGRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

public class TestNGRunner {

	public static void main(String[] args) {
		
		String failedTestNG = "test-output\\Suite\\testng-failed.xml";
		TestNG testng = new TestNG();
		List<String> suites = new ArrayList<String>();	
		
		testng.setTestSuites(suites);
		testng.run();
		
		for(int i=0;i<3;i++) {
			
				suites = new ArrayList<String>();
				File file = new File("test-output\\Suite\\testng-failed.xml");
				
				if(file.exists())
					suites.add("test-output\\Suite\\testng-faileds.xml");
				else 
					break;
				
				testng.setTestSuites(suites);
				testng.run();
				
				
			
		}

		System.out.println("Exited out of look");
	}

}
