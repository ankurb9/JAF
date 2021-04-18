package org.restassured.api.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.ParseException;
import org.api.uitils.HTTPCommunication;
import org.enums.collection.HTTPMethod;
import org.enums.collection.Request;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.http.HttpMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Basicapi_test {
	
	@Test(enabled = true)
	public void testAPI() throws ParseException, IOException {
		
		Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22");
		
		System.err.println(response.body().jsonPath().prettify());
		
		JsonPath j = new JsonPath(response.body().jsonPath().prettify()).setRootPath("coord");
		
		//System.err.println(j.get("lon"));
	}
	
	@Test(enabled = true)
	public void postTest() {
		
		RequestSpecification req =RestAssured.given();
		
		req.header("Content-Type", "application/json");
		req.body("{ \"id\": 6, \"title\": \"json-server\", \"author\": \"typicode\" }");
		
		Response resp = req.post("http://localhost:3000/posts");
		
		
		  System.err.println(resp.getStatusLine());
		  System.err.println(resp.jsonPath().prettify());
		 
		Map<String, String> headermap = new HashMap<String,String>();
		
	
		for(Header hm:resp.getHeaders() ) {
			headermap.put(hm.getName(), hm.getValue());
		}
		
		System.err.println(resp.getHeaders());

	}
	
	/*
	 * @Test(enabled = false) public void commonClass() throws Exception {
	 * 
	 * 
	 * Map<String, String> hMap = new HashMap<String, String>();
	 * hMap.put("Content-Type", "application/json");
	 * 
	 * HTTPHelper hh = new HTTPHelper(); Map<String, ?> respMap =
	 * hh.req(HTTPMethod.get, "http://localhost:3000/posts/4", null);
	 * System.err.println(respMap);
	 * 
	 * 
	 * }
	 */
	
	@Test(enabled = false)
	public void commonClass1() throws Exception {
		
		
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("Content-Type", "application/json");
		
		HTTPCommunication hh = new HTTPCommunication();
		
		HashMap<Request,Object> req = new HashMap<Request, Object>();
		
		req.put(Request.header, hMap);
		req.put(Request.body, null);
		req.put(Request.uri, "http://localhost:3000/posts/3");	
		
		  Map<String, ?> respMap = hh.request(req);	
		
	}
	
	@Test(enabled = false)
	public void auth() {
		HTTPCommunication httphelper = new HTTPCommunication();
		Map<Request,Object> reqMap = new HashMap<Request, Object>();
		reqMap.put(Request.uri,"http://localhost:3000/posts/3");
		reqMap.put(Request.method, HTTPMethod.GET);
		
		try {
			System.err.println(httphelper.request(reqMap));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		/*
		 * RequestSpecification auth = RestAssured.given().auth().basic("ToolsQA",
		 * "TestPassword");
		 * 
		 * 
		 * Response resp =
		 * auth.get("http://restapi.demoqa.com/authentication/CheckForAuthentication");
		 * System.err.println(resp.asString());
		 */
		
		//RestAssured.authentication = RestAssured.basic("ToolsQA", "TestPassword");
	}
	
	

}
