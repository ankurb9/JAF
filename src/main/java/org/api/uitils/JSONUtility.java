package org.api.uitils;

import java.util.ArrayList;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

public class JSONUtility {
	
	
	public static List<String> getValueFromJSON(String json, String jsonPath){
	    
	   
	    
	    
	return JsonPath.read(json, jsonPath);
	  
	    
	  
	     
	    
	}

}
