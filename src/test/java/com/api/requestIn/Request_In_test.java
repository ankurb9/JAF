package com.api.requestIn;

import java.util.HashMap;
import java.util.Map;

import org.api.uitils.HTTPCommunication;
import org.enums.collection.HTTPMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import jaf.common.utility.JAF;
import jaf.common.utility.TC;
import jaf.driver.utilities.JAFBase;

public class Request_In_test {
	
	HTTPCommunication httpComm = new HTTPCommunication();
	
	@Test
	public void validate_get_request_Test() {
		
		try {
			
		//	TC.get().APIName = "GetUsers-Page2";
			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Content-Type", "application/json");
			Map<String, String> responseMap = httpComm.executeHTTPRequest(HTTPMethod.GET, "https://reqres.in/api/users/2", headerMap);
			System.out.println(responseMap.get("BODY"));
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
