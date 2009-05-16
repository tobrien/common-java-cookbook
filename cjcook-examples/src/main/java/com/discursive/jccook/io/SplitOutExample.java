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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.TeeOutputStream;


public class SplitOutExample {
	public static void main(String[] args) {
		new SplitOutExample().start();
	}
	
	public void start() {
		File test1 = new File("split1.txt");
		File test2 = new File("split2.txt");
		OutputStream outStream = null;
		
		try {
			FileOutputStream fos1 = new FileOutputStream( test1 );
			FileOutputStream fos2 = new FileOutputStream( test2 );
			outStream = new TeeOutputStream( fos1, fos2 );
			
			outStream.write( "One Two Three, Test".getBytes() );
		} catch( IOException ioe ) {
			System.out.println( "Error writing to split output stream" );
		} finally {
			IOUtils.closeQuietly( outStream );
		}
	}

}
