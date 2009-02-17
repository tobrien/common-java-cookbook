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
package com.discursive.jccook.collections.lazy;

import java.net.URL;
import java.util.Map;

import org.apache.commons.collections.map.LRUMap;
import org.apache.commons.collections.map.LazyMap;

public class LazyMapExample {

	Map stockQuotes;

	public static void main(String[] args) throws Exception {
		LazyMapExample example = new LazyMapExample();
		example.start();
	}
	
	public void start() throws Exception {
		
		StockQuoteTransformer sqTransformer = new StockQuoteTransformer();
		sqTransformer.setQuoteURL( new URL("http://quotes.company.com") );
		sqTransformer.setTimeout( 500 );
		
		stockQuotes = new LRUMap( 5 );
		stockQuotes = LazyMap.decorate( stockQuotes, sqTransformer );
		
		// Now use some of the entries in the cache
		Float cscoPrice  = (Float) stockQuotes.get( "CSCO" );
		Float msPrice = (Float) stockQuotes.get( "MSFT" );
		Float tscPrice = (Float) stockQuotes.get( "TSC" );
		Float luPrice = (Float) stockQuotes.get( "LU" );
		Float pPrice = (Float) stockQuotes.get( "P" );
		Float msPrice2 = (Float) stockQuotes.get( "MSFT" );
		
		// Add another price to the Map, this should kick out the LRU item.
		stockQuotes.put( "AA",			new Float( 203.20 ) );
		
		// CSCO was the first price requested, it is therefor the
		// least recently used.
		if( !stockQuotes.containsKey("CSCO") ) {
			System.out.println( "As expected CSCO was discarded" );
		}
	}
}
