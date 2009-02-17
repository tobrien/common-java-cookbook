/* 
 * ========================================================================
 * 
 * Copyright 2005 Tim O'Brien.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * ========================================================================
 */
package com.discursive.jccook.collections.bidi;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.TreeBidiMap;

public class BidiMapExample {

	private BidiMap countryCodes = new TreeBidiMap();

	public static void main(String[] args) {
		BidiMapExample example = new BidiMapExample();
		example.start();
	}
	
	
	private void start() {
		populateCountryCodes();
		
		String countryName = (String) countryCodes.get( "tr" );
		System.out.println( "Country Name for code 'tr': " + countryName );

		String countryCode = (String) countryCodes.inverseBidiMap().get("Uruguay");
		System.out.println( "Country Code for name 'Uruguay': " + countryCode );
			
		countryCode = (String) countryCodes.getKey("Ukraine");
		System.out.println( "Country Code for name 'Ukraine': " + countryCode );
	}
	
	private void populateCountryCodes() {
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
	}
}

