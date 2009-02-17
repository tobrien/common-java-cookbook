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
package com.discursive.jccook.slide;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.webdav.lib.WebdavResource;

public class GetExample {

	public static void main(String[] args) throws HttpException, IOException {
		HttpClient client = new HttpClient();

		String url = "http://www.discursive.com/jccook/dav/test.html";
		Credentials credentials =
			new UsernamePasswordCredentials("davuser", "davpass");

		// List resources in top directory
		WebdavResource resource = new WebdavResource(url, credentials);

		System.out.println( "The three ways to Read resources.");

		// Read to a temporary file
		File tempFile = new File( resource.getName() );
		resource.getMethod( tempFile );
		System.out.println( "1. " + resource.getName() + " saved in file: " + tempFile.toString() );

		// Read as a String
		String resourceData = resource.getMethodDataAsString();
		System.out.println( "2. Contents of " + resource.getName() + " as String." );
		System.out.println( resourceData );
		
		// Read with a stream
		InputStream resourceStream = resource.getMethodData();
		Reader reader = new InputStreamReader( resourceStream );
		StringWriter writer = new StringWriter();
		while( reader.ready() ) { writer.write( reader.read() ); }
		System.out.println( "3. Contents of " + resource.getName() + " from InputStream.");
		System.out.println( writer.toString() );
		
		resource.close();		
		
	}
	
}
