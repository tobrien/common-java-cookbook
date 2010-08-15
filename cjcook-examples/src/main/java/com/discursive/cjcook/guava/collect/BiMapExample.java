	package com.discursive.cjcook.guava.collect;
	
	import com.google.common.collect.BiMap;
	import com.google.common.collect.HashBiMap;
	
	public class BiMapExample {
		public static void main(String[] args) {
			
			BiMap<String, String> countryCodes = HashBiMap.create();
			
	        countryCodes.put("to","Tonga");
	        countryCodes.put("tr","Turkey");
	        countryCodes.put("tv","Tuvalu");
	        countryCodes.put("tz","Tanzania");
	        countryCodes.put("ua","Ukraine");
	        countryCodes.put("ug","Uganda");
	        countryCodes.put("uk","United Kingdom");
	        countryCodes.put("um","USA Minor Outlying Islands");
	        countryCodes.put("us","United States");
	        countryCodes.put("uy","Uruguay");
	
	        String countryName = (String) countryCodes.get( "tr" );
	        System.out.println( "Country Name for code 'tr': " + countryName );
	
	        String countryCode = 
	            (String) countryCodes.inverse().get("Uruguay");
	        System.out.println( "Country Code for name 'Uruguay': " + countryCode );
	            
	    }
	    
	}
