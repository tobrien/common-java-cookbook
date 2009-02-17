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

import org.apache.commons.beanutils.PropertyUtils;

public class NestedPropertyExample {

	public static void main(String[] args) {
		NestedPropertyExample example = new NestedPropertyExample();
		example.start();
	}
	
	private void start() {
		
		// Create an author
		Author wolfe = new Author( "Tom Wolfe", "Green" );
		Book theRightStuff = new Book( "The Right Stuff", wolfe );
		
		try {
			String bookName = (String) PropertyUtils.getSimpleProperty( theRightStuff, "name" );
			String authorName = (String) PropertyUtils.getNestedProperty( theRightStuff, "author.name" );
			
			System.out.println( "The book is " + bookName );
			System.out.println( "The author is " + authorName );
		} catch (Exception e) {
			System.out.println( "There was a problem getting a bean property." );
			e.printStackTrace();
		}
		
		
	}
}
