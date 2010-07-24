package com.discursive.cjcook.json;

import net.sf.json.JSONObject;

public class GeneratingJSON {

    public static void main(String[] args) throws Exception {

        JSONObject json = new JSONObject();
        
        // Put a simple element
        json.put( "aircraft", "A320");
        
        // Add a JSON Object
        JSONObject pilot = new JSONObject();
        pilot.put( "firstName", "John");
        pilot.put( "lastName", "Adams");
        json.put( "pilot", pilot);

        // Accumulate values in an array
        json.accumulate("passenger", "George Washington");
        json.accumulate("passenger", "Thomas Jefferson");
        
        // Passing a number to toString() adds indentation
        System.out.printf( "JSON: %s", json.toString(2) );
    }
}
