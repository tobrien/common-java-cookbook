package com.discursive.cjcook.json;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class ConvertMaptoJSON {

	public static void main(String[] args) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put( "name", "Marshall Mathers" );
		data.put( "age", 37 );
		data.put( "city", "Detroit" );
		
		JSONObject json = new JSONObject();
		json.putAll( data );
		System.out.printf( "JSON: %s", json.toString(2) );
	}
}
