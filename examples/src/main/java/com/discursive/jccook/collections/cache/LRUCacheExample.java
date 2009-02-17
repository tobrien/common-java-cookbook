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
package com.discursive.jccook.collections.cache;

import java.util.Map;

import org.apache.commons.collections.map.LRUMap;

public class LRUCacheExample {

	private Map cache;

	public static void main(String[] args) {
		LRUCacheExample example = new LRUCacheExample();
		example.start();
	}
	
	private void start() {
		cache = new LRUMap( 5 );
		
		// Populate the cache with 5 stock prices
		cache.put( "MSFT", 	new Float( 0.03 ) );
		cache.put( "TSC", 		new Float( 0.001 ) );
		cache.put( "LU", 		new Float( 23.30 ) );
		cache.put( "CSCO", 	new Float( 242.20 ) );
		cache.put( "P", 			new Float( 10.23 ) );
		
		// Now use some of the entries in the cache
		Float cscoPrice  = (Float) cache.get( "CSCO" );
		Float msPrice = (Float) cache.get( "MSFT" );
		Float tscPrice = (Float) cache.get( "TSC" );
		Float luPrice = (Float) cache.get( "LU" );
		Float pPrice = (Float) cache.get( "P" );
		Float msPrice2 = (Float) cache.get( "MSFT" );
		
		// Add another price to the Map, this should kick out the LRU item.
		cache.put( "AA",			new Float( 203.20 ) );
		
		// CSCO was the first price requested, it is therefor the
		// least recently used.
		if( !cache.containsKey("CSCO") ) {
			System.out.println( "As expected CSCO was discarded" );
		}
	}
}
