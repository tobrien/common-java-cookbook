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

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.CopyUtils;

public class CopyExample {
	public static void main(String[] args) {
		new CopyExample().start();
	}
	
	public void start() {
		try {
			Writer writer = new FileWriter( "test.dat" );
			InputStream inputStream = 
				getClass().getResourceAsStream("./test.resource");
			CopyUtils.copy( inputStream, writer );
			writer.close();
			inputStream.close();
		} catch (IOException e) {
			System.out.println( "Error copying data" );
		}
		
	}
}
