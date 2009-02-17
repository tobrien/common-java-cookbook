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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

public class MultithreadedExample {

	public static void main(String[] args) throws HttpException, IOException, InterruptedException {
		MultithreadedExample example = new MultithreadedExample();
		example.start();
	}
	
	public void start() throws InterruptedException {
		HttpConnectionManager connectionManager = 
					new MultiThreadedHttpConnectionManager();
					
		HttpConnectionManagerParams params = connectionManager.getParams();
		params.setIntParameter( HttpConnectionManagerParams.MAX_HOST_CONNECTIONS, 2 );
		params.setIntParameter( HttpConnectionManagerParams.MAX_TOTAL_CONNECTIONS, 4 );

		List retrievers = new ArrayList();

		for( int i = 0; i < 20; i++ ) {
			HttpClient client = new HttpClient(connectionManager);
			Thread thread = new Thread( new PageRetriever(client) );
			retrievers.add( thread );
		}
		
		Iterator threadIter = retrievers.iterator();
		while( threadIter.hasNext() ) {
			Thread thread = (Thread) threadIter.next();
			thread.start();
		} 
	}
	
	public class PageRetriever implements Runnable {
		private HttpClient client;

		public PageRetriever(HttpClient client) {
			this.client = client;
		}

		public void run() {
			String url = "http://www.discursive.com/jccook";
		
			HttpMethod method = new GetMethod( url );
			try {
				client.executeMethod( method );
				String response = method.getResponseBodyAsString();
			} catch(Exception e) {
				System.out.println( "Error making request" );
			}
			method.releaseConnection();
			method.recycle();
		}
	}
}
