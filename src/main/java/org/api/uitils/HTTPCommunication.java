package org.api.uitils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.enums.collection.HTTPMethod;
import org.enums.collection.Request;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jaf.common.utility.JAF;
import jaf.common.utility.TC;

public class HTTPCommunication {
	/**
	 * This is method to send multiple http request
	 *
	 *@param Accepts the request map () with Key = key(enum) and Value = Object (any object such as String, Map, URI) ()
	 *
	 * @return Response Map Map<String, String>.
	 */


	@SuppressWarnings("unchecked")
	public  Map<String, String> request(Map<Request,Object> requestMap) throws Exception {

		RequestSpecification request = RestAssured.given();
		Response response = null;	
		String uri =  requestMap.get(Request.uri).toString();

		HTTPMethod httpmethod =  (HTTPMethod) requestMap.get(Request.method);	

		String body = requestMap.containsKey(Request.body)?requestMap.get(Request.body).toString():"";
		request.body(body);

		Map<String, String> headerMap = requestMap.containsKey(Request.header)?(HashMap<String,String>)requestMap.get(Request.header):new HashMap();
		request.headers(headerMap);

		String authType =	(String) (requestMap.containsKey(Request.authType)?requestMap.get(Request.authType):"");


		if(authType.equalsIgnoreCase("basic")) {
			String username = requestMap.get(Request.userName).toString();
			String password = requestMap.get(Request.password).toString();
			request.auth().basic(username, password);
		}


		switch (httpmethod) {
		case GET:
			response =request.get(uri);
			break;
		case POST:
			response =request.post(uri);
			break;
		case PUT:
			response =request.put(uri);
			break;
		case DELETE:
			response =request.delete(uri);
			break;
		case PATCH:
			response =request.delete(uri);
			break;
		default:
			throw new Exception(uri);
		}
		
		return createResponseMap(response,0);
	}

	public  Map<String, String> executeHTTPRequest(HTTPMethod httpmethod,String uri,Map<String, String> headerMap, String...body) throws Exception {

		RequestSpecification request = RestAssured.given();		
		
		JAF.log("*****************************************************************************************************************************");
	//	JAF.log(TC.get().APIName + " API Started");
		JAF.log("***********************************Request Parameters***********************************************************************");
		
		JAF.log("Method: "+ httpmethod);
		JAF.log("URI: "+uri);
		
		if(headerMap!=null && !headerMap.isEmpty()) {
			request.headers(headerMap);
			JAF.log("Headers:");
			for(Map.Entry<String, String> map : headerMap.entrySet())	
				JAF.log(map.getKey() +" : "+map.getValue());	
		}

		if(body.length!=0) {
			request.body(body);
			JAF.log("Reqeust BODY:\n"+body);
		}	
		
		return submitReqeust(httpmethod, uri , request); 
	}
	
	private Map<String, String> submitReqeust(HTTPMethod httpmethod, String uri, RequestSpecification request) throws Exception{
		long startTime=0;
		long endTime=0;
		Response response = null;	
		
		switch (httpmethod) {
		case GET:
			startTime = System.currentTimeMillis();
			response =request.get(uri);
			endTime = System.currentTimeMillis();
			break;
		case POST:
			startTime = System.currentTimeMillis();
			response =request.post(uri);
			break;
		case PUT:
			startTime = System.currentTimeMillis();
			response =request.put(uri);
			endTime = System.currentTimeMillis();
			break;
		case DELETE:
			startTime = System.currentTimeMillis();
			response =request.delete(uri);
			endTime = System.currentTimeMillis();
			break;
		case PATCH:
			startTime = System.currentTimeMillis();
			response =request.delete(uri);
			endTime = System.currentTimeMillis();
			break;
		default:
			throw new Exception("HttpMethod not found");
		}			
		JAF.log("***********************************Response Parameters***********************************************************************");
		return createResponseMap(response,endTime-startTime);
	}

	private Map<String, String> createResponseMap(Response respose, long resposeTimeInMiliSec) throws IOException{

		Map<String,String> responseMap = new HashMap<String, String>();	
		for(Header hm:respose.getHeaders() ) {
			responseMap.put(hm.getName().toString(), hm.getValue().toString());
		}
		responseMap.put("StatusCode",String.valueOf(respose.getStatusCode()));
		responseMap.put("StatusLine",respose.getStatusLine());
		responseMap.put("BODY",respose.asString());
		responseMap.put("ResponseTime", String.valueOf(resposeTimeInMiliSec) +" ms");
		
		for(Map.Entry<String, String> map : responseMap.entrySet())	
			JAF.log(map.getKey() +" : "+map.getValue());			
			
		//JAF.log("*************************"+TC.get().APIName+" API Ended******************************************************");
		return responseMap;
	}



}
