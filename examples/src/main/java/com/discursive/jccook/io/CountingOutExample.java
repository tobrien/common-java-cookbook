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

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.CountingOutputStream;

public class CountingOutExample {
	public static void main(String[] args) {
		new CountingOutExample().start();
	}
	
	public void start() {

		File test = new File( "test.dat" );
		CountingOutputStream countStream = null;

		try {
			FileOutputStream fos = new FileOutputStream( test );
			countStream = new CountingOutputStream( fos );
			countStream.write( "Hello".getBytes() );
		} catch( IOException ioe ) {
			System.out.println( "Error writing bytes to file." );
		} finally {
			IOUtils.closeQuietly( countStream );
		}

		if( countStream != null ) {
			int bytesWritten = countStream.getCount();
			System.out.println( "Wrote " + bytesWritten + " bytes to test.dat" );
		}

	}

}
