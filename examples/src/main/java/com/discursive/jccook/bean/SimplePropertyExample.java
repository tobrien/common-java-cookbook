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
package com.discursive.jccook.bean;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

public class SimplePropertyExample {

	public static void main(String[] args) {
		SimplePropertyExample example = new SimplePropertyExample();
		example.start();
	}
	
	private void start() {
		
		// Create an author
		Author wolfe = new Author( "Tom Wolfe", "Green" );
		
		try {
			String name = (String) PropertyUtils.getSimpleProperty( wolfe, "name" );
			String favoriteColor = (String) PropertyUtils.getSimpleProperty( wolfe, "favoriteColor" );
			
			System.out.println( "The Author has some properties: " + name + ", " + favoriteColor );
		} catch (IllegalAccessException e) {
			System.out.println( "You are not allowed to access a property!" );
		} catch (InvocationTargetException e) {
			System.out.println( "There was a problem invoking the method." );
		} catch (NoSuchMethodException e) {
			System.out.println( "The is no method to get a property." );
		}
		
		
	}
}
