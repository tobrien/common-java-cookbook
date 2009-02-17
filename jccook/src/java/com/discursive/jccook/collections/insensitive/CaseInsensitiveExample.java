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
package com.discursive.jccook.collections.insensitive;

import java.util.Map;

import org.apache.commons.collections.map.CaseInsensitiveMap;

public class CaseInsensitiveExample {

	Map states = new CaseInsensitiveMap();

	public static void main(String[] args) {
		CaseInsensitiveExample example = new CaseInsensitiveExample();
		example.start();
	}
	
	private void start() {
		states.put("IL", "Illinois");
		states.put("PA", "Pennsylvania");
		states.put("GA", "Georgia");
		states.put("AZ", "Arizona");
	
		String stateName = (String) states.get( "il" );
		System.out.println( "Value retrieved for 'il': " + stateName );

		stateName = (String) states.get( "IL" );
		System.out.println( "Value retrieved for 'IL': " + stateName );

		stateName = (String) states.get( "iL" );
		System.out.println( "Value retrieved for 'iL': " + stateName );

	}
}
