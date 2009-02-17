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

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HeaderElement;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

public class ConditionalGetExample {

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

		ConditionalGetExample example = new ConditionalGetExample();
		example.start();
	}
	
	String entityTag = "";
	String lastModified = "";
	
	public void start() throws HttpException, IOException {

		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod("http://www.apache.org");

		for( int i = 0; i < 3; i++ ) {
			setHeaders(method);
			client.executeMethod(method);
			processResults(method);
			method.releaseConnection();
			method.recycle();
		}
	}

	private void setHeaders(HttpMethod method) {
		method.setRequestHeader(new Header("If-None-Match", entityTag ) );
		method.setRequestHeader(new Header("If-Modified-Since", lastModified ) );
	}

	private void processResults(HttpMethod method) throws HttpException {
		if(method.getStatusCode() == HttpStatus.SC_NOT_MODIFIED ) {
			System.out.println( "Content not modified since last request" );
		} else {
			System.out.println( "Get Method retrieved content." );
			entityTag = retrieveHeader( method, "ETag" );
		  	lastModified = retrieveHeader( method, "Last-Modified" );
			System.out.println( "Entity Tag: " + entityTag );
			System.out.println( "Last Modified: " + lastModified );
		} 
	}
	
	private String retrieveHeader( HttpMethod method, String name ) throws HttpException {
		HeaderElement[] header = method.getResponseHeader(name).getElements();
		String value = "";
		if(header.length > 0) {
		 value = header[0].getName();
		}
		return value;
	}
}
