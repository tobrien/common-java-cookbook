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

import java.io.IOException;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.webdav.lib.WebdavResource;

public class ModifyExample {

	public static void main(String[] args) throws HttpException, IOException {
		HttpClient client = new HttpClient();

		String url = "http://www.discursive.com/jccook/dav/test.html";
		Credentials credentials =
			new UsernamePasswordCredentials("davuser", "davpass");

		// List resources in top directory
		WebdavResource resource = new WebdavResource(url, credentials);

		// Lock the Resource for 100 seconds
		boolean locked = resource.lockMethod( "tobrien", 100 );

		if( locked ) {
			try {
				// Read content as a String
				String resourceData = resource.getMethodDataAsString();
				printResource(resource, resourceData);
		
				// Modify a resource
				System.out.println( "*** Modifying Resource");
				resourceData = resourceData.replaceAll( "test", "modified test" );
				resource.putMethod( resourceData );
			} finally {
				// Unlock the resource
				resource.unlockMethod( "tobrien" );
			}
		}
		
		// Close the resource	
		resource.close();		
	}
	
	private static void printResource(WebdavResource resource, 
									  String resourceData) {
		System.out.println( "*** Contents of " + resource.getName() );
		System.out.println( resourceData );
	}
	
}
