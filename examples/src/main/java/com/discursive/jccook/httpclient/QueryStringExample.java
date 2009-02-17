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
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.URIUtil;

public class QueryStringExample {
	public static void main(String[] args) throws HttpException, IOException {
		HttpClient client = new HttpClient();

		String url = "http://www.discursive.com/cgi-bin/jccook/param_list.cgi";

		// Set the Query String with setQueryString()
		HttpMethod method = new GetMethod( url );
		method.setQueryString( URIUtil.encodeQuery( "test1=O'Reilly&blah=Whoop" ) );
		System.out.println( "With Query String: " + method.getURI() );
		client.executeMethod( method );
		System.out.println( "Response:\n " + method.getResponseBodyAsString() );
		method.releaseConnection();
		
		// Set query string with name value pair objects
		method = new GetMethod( url );
		NameValuePair pair = new NameValuePair( "test2", URIUtil.encodeQuery( "One & Two" ) );
		NameValuePair pair2 = new NameValuePair( "param2", URIUtil.encodeQuery( "TSCM" ) );
		NameValuePair[] pairs = new NameValuePair[] { pair, pair2 };
		method.setQueryString( pairs );
		System.out.println( "With NameValuePairs: " + method.getURI() );
		client.executeMethod( method );
		System.out.println( "Response:\n " + method.getResponseBodyAsString() );
		method.releaseConnection();
	}
}
