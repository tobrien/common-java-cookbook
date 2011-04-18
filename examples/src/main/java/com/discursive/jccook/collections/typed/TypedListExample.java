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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.list.TypedList;

public class TypedListExample {
	
	private List hostNames;

	public static void main(String[] args) {
		TypedListExample example = new TypedListExample();
		example.start();
	}
	
	public void start() {
		// Make sure that items added to this
		hostNames = TypedList.decorate(  new ArrayList(), String.class );

		// Add two String objects
		hostNames.add( "papp01.thestreet.com" );
		hostNames.add( "test.slashdot.org" );
		
		// Try to add an Integer
		try {		
			hostNames.add( new Integer(43) );
		} catch( IllegalArgumentException iae ) {
			System.out.println( "Adding an Integer Failed as expected" );
		}
		
		// Now we can safely cast without the possibility of a ClassCastException
		String hostName = (String) hostNames.get(0);
		
	}
}
