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
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class FileCopyExample {
	public static void main(String[] args) {
		try {
			File src = new File( "test.dat" );
			File dest = new File( "test.dat.bak" );
			
			FileUtils.copyFile( src, dest );
		} catch( IOException ioe ) {
			System.out.println( "Problem copying file." );
		}
		
		try {
			File src = new File( "test.dat" );
			File dir = new File( "./temp" );

			FileUtils.copyFileToDirectory( src, dir );
		} catch( IOException ioe ) {
			System.out.println( "Problem copying file to dir.");
		}
		
		try {
			String string = "Blah blah blah";
			File dest = new File( "test.tmp" );
			
			FileUtils.writeStringToFile( dest, string, "ISO-8859-1" );
		} catch( IOException ioe ) {
			System.out.println( "Error writing out a String." );			
		}
	}

}
