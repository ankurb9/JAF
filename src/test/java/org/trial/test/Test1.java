package org.trial.test;

import java.io.IOException;

import org.constants.variables.ThreadConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

import jaf.common.utility.ThreadConstantSetup;
import jaf.driver.utilities.JAFBase;


public class Test1 extends JAFBase{

	@Test()
	public void test1m1() throws IOException {
		try {		
			ThreadConstants tc = ThreadConstantSetup.get();
			Assert.fail("Failed");
			System.out.println("test->"+tc.test);	
			System.out.println("class->"+tc.class1);
			System.out.println("method->"+tc.APIName);
			
	
			
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}


	@Test()
	public void test1m2() throws IOException {
		try {		
			ThreadConstants tc = ThreadConstantSetup.get();

			System.out.println("test->"+tc.test);	
			System.out.println("class->"+tc.class1);
			System.out.println("method->"+tc.APIName);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}	

	}


}
