package com.discursive.cjcook.json;

import java.io.InputStream;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.io.IOUtils;

public class ParsingJSON {

    public static void main(String[] args) throws Exception {
        InputStream is = 
                ParsingJSON.class.getResourceAsStream( "sample-json.txt");
        String jsonTxt = IOUtils.toString( is );
        
        JSONObject json = (JSONObject) JSONSerializer.toJSON( jsonTxt );        
        double coolness = json.getDouble( "coolness" );
        int altitude = json.getInt( "altitude" );
        JSONObject pilot = json.getJSONObject("pilot");
        String firstName = pilot.getString("firstName");
        String lastName = pilot.getString("lastName");
        
        System.out.printf( "Coolness: %f\n", coolness );
        System.out.printf( "Altitude: %d\n", altitude );
        System.out.printf( "Pilot: %s %s\n", firstName, lastName );
    }
}
