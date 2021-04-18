package com.api.requestIn;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;
import org.openqa.selenium.SearchContext;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

public class JSONPath {

    static String json = "{\r\n" + " \"store\":\r\n" + " {\r\n" + " \"book\":\r\n" + " [\r\n" + " {\r\n"
	    + " \"category\": \"reference\",\r\n" + " \"author\": \"Nigel Rees\",\r\n"
	    + " \"title\": \"Sayings of the Century\",\r\n" + " \"price\": 8.95\r\n" + " },\r\n" + " {\r\n"
	    + " \"category\": \"fiction\",\r\n" + " \"author\": \"Evelyn Waugh\",\r\n"
	    + " \"title\": \"Sword of Honour\",\r\n" + " \"price\": 12.99\r\n" + " }\r\n" + " ],\r\n"
	    + " \"bicycle\":\r\n" + " {\r\n" + " \"color\": \"red\",\r\n" + " \"price\": 19.95\r\n" + " }\r\n"
	    + " }\r\n" + " }";

    public static void main(String[] args) {
	
	
	  List<String> authors = JsonPath.read(json, "$.store.book[*].author");
	  System.out.println("authors: " + authors); // print
	  
	  
	  System.out.println(JsonPath.read(json,"$..category").getClass().equals(JSONArray.class));
	  
	  List<Map<String,String>> str = JsonPath.parse(json).read("$.store.book",List.class);
	  
	  System.out.println(str.get(0));
	 
	 


    }

}
