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
package com.discursive.jccook.io;

import java.io.File;

import org.apache.commons.io.FileUtils;


public class FileDeleteExample {
	public static void main(String[] args) {
		new FileDeleteExample().start();
	}
	
	public void start() {
		File file = new File( "project.xml" );
		String display = FileUtils.byteCountToDisplaySize( file.length() );
		System.out.println( "project.xml is " + display );
		System.out.println( "Byte in KB: " + FileUtils.ONE_GB );

		display = FileUtils.byteCountToDisplaySize( 12073741824l );
		System.out.println( "size: " + display );
	}
}
