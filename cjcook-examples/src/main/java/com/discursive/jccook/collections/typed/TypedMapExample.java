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
package com.discursive.jccook.collections.typed;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.TypedMap;

public class TypedMapExample {
	
	private Map variables;

	public static void main(String[] args) {
		TypedMapExample example = new TypedMapExample();
		example.start();
	}
	
	public void start() {
		// Make sure that items added to this
		variables = TypedMap.decorate(  new HashMap(), String.class, Number.class );

		// Add two String objects
		variables.put( "maxThreads", new Integer(200) );
		variables.put( "minThreads", new Integer(20) );
		variables.put( "lightSpeed", new Double( 2.99792458e8 ) );
		
		// Try to add a String value
		try {		
			variables.put( "server", "test.oreilly.com" );
		} catch( IllegalArgumentException iae ) {
			System.out.println( "Adding an String value Failed as expected" );
		}

		// Try to add an Integer key
		try {		
			variables.put( new Integer(30), "test.oreilly.com" );
		} catch( IllegalArgumentException iae ) {
			System.out.println( "Adding an Integer key Failed as expected" );
		}
		
		// Now we can safely cast without the possibility of a ClassCastException
		Number reading = (Number) variables.get("lightSpeed");
		
	}
}
