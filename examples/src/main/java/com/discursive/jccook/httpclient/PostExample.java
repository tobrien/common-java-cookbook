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
package com.discursive.jccook.httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


public class PostExample {
	public static void main(String[] args) throws HttpException, IOException {

		// Configure Logging
		System.setProperty("org.apache.commons.logging.Log", 
			"org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.showdatetime", 
			"true");
		System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", 
			"debug");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", 
			"debug");

		HttpClient client = new HttpClient();
		
		// Create POST method
		String weblintURL = "http://www.discursive.com/cgi-bin/jccook/param_list.cgi";
		PostMethod method = new PostMethod( weblintURL );

		// Set parameters on POST	
		method.setParameter( "test1", "Hello World" );
		method.addParameter( "test2", "This is a Form Submission" );
		method.addParameter( "Blah", "Whoop" );
		method.addParameter( new NameValuePair( "Blah", "Whoop2" ) );

		// Execute and print response
		client.executeMethod( method );
		String response = method.getResponseBodyAsString();
		System.out.println( response );

		method.releaseConnection();
	}

}
