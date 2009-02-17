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

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;


public class BasicAuthExample {

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
		HttpState state = client.getState();
		HttpClientParams params = client.getParams();
	
		// Set credentials on the client
		Credentials credentials =
			new UsernamePasswordCredentials( "testuser", "crazypass" );
		state.setCredentials( null, null, credentials );
		params.setAuthenticationPreemptive( true );

		String url = "http://www.discursive.com/jccook/auth/";
		HttpMethod method = new GetMethod( url );
	
		client.executeMethod( method );
		String response = method.getResponseBodyAsString();

		System.out.println( response );
		method.releaseConnection();
	}
}
