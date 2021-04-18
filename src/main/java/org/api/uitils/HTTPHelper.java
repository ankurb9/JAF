package org.api.uitils;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.enums.collection.HTTPMethod;
import org.enums.collection.Request;

import jaf.common.utility.TC;

public class HTTPHelper {

	@SuppressWarnings("unchecked")
	public static Map<String, String> HTTPRequest(HTTPMethod httpMethod, String uri, Map<Request, String>...authDetails) throws Exception{
		
		HTTPCommunication httpCommunication = new HTTPCommunication();
		
		Map<Request,Object> requestMap = new HashedMap();

		requestMap.put(Request.method, httpMethod);
		requestMap.put(Request.uri, uri);

		if(authDetails.length!=0) 
			requestMap.putAll(authDetails[0]);

		return httpCommunication.request(requestMap);	
	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> HTTPRequest(HTTPMethod httpMethod, String uri, Map<String, String> headerMap, Map<Request, String>...authDetails) throws Exception{
		
		HTTPCommunication httpCommunication = new HTTPCommunication();
		Map<Request,Object> requestMap = new HashedMap();

		requestMap.put(Request.method, httpMethod);
		requestMap.put(Request.uri, uri);
		requestMap.put(Request.header, headerMap);

		if(authDetails.length!=0) 
			requestMap.putAll(authDetails[0]);

		return httpCommunication.request(requestMap);

	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> HTTPRequest(HTTPMethod httpMethod, String uri, Map<String, String> headerMap, String body, Map<Request, String>...authDetails) throws Exception{
		HTTPCommunication httpCommunication = new HTTPCommunication();
		Map<Request,Object> requestMap = new HashedMap();

		requestMap.put(Request.method, httpMethod);
		requestMap.put(Request.uri, uri);
		requestMap.put(Request.header, headerMap);
		requestMap.put(Request.body, body);

		if(authDetails.length!=0) 
			requestMap.putAll(authDetails[0]);

		return httpCommunication.request(requestMap);

	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> HTTPRequest(HTTPMethod httpMethod, String uri, String body, Map<Request, String>...authDetails) throws Exception{
		HTTPCommunication httpCommunication = new HTTPCommunication();
		
		Map<Request,Object> requestMap = new HashedMap();
		requestMap.put(Request.method, httpMethod);
		requestMap.put(Request.uri, uri);
		requestMap.put(Request.body, body);

		if(authDetails.length!=0) 
			requestMap.putAll(authDetails[0]);

		return httpCommunication.request(requestMap);

	}	

}
