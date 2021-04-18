package org.trial.test;

import java.io.IOException;

import org.constants.variables.ThreadConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import jaf.common.utility.ThreadConstantSetup;
import jaf.driver.utilities.JAFBase;


public class Test3 {

	@Test()
	public void test1m1() throws IOException {
		try {		
			
			String json = "{\r\n" + 
					"    id: 1,\r\n" + 
					"    name: \"Leanne Graham\",\r\n" + 
					"    username: \"Bret\",\r\n" + 
					"    email: \"Sincere@april.biz\",\r\n" + 
					"    address: {\r\n" + 
					"        street: \"Kulas Light\",\r\n" + 
					"        suite: \"Apt. 556\",\r\n" + 
					"        city: \"Gwenborough\",\r\n" + 
					"        zipcode: \"92998-3874\",\r\n" + 
					"        geo: {\r\n" + 
					"            lat: \"-37.3159\",\r\n" + 
					"            lng: \"81.1496\"\r\n" + 
					"        }\r\n" + 
					"    },\r\n" + 
					"    phone: \"1-770-736-8031 x56442\",\r\n" + 
					"    website: \"hildegard.org\",\r\n" + 
					"    company: {\r\n" + 
					"        name: \"Romaguera-Crona\",\r\n" + 
					"        catchPhrase: \"Multi-layered client-server neural-net\",\r\n" + 
					"        bs: \"harness real-time e-markets\"\r\n" + 
					"    }\r\n" + 
					"}";
			
			JsonPath js = new JsonPath(json);
			
			System.out.println(js.getJsonObject("street"));
	
			
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}





}
