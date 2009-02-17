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
package com.discursive.jccook.collections.lazy;

import java.net.URL;

import org.apache.commons.collections.Transformer;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpURL;
import org.apache.commons.httpclient.methods.GetMethod;

public class StockQuoteTransformer implements Transformer {

	protected URL quoteURL;
	protected long timeout;

	public Object transform(Object symbol) {
		QuoteRetriever retriever = new QuoteRetriever( (String) symbol );
		
		try {
			Thread retrieveThread = new Thread( retriever );
			retrieveThread.start();
			retrieveThread.join( timeout );
		} catch( InterruptedException ie ) {
			System.out.println( "Quote request timed out.");
		}
		
		return retriever.getResult();
	}

	public URL getQuoteURL() { return quoteURL; }
	public void setQuoteURL(URL url) { quoteURL = url; }

	public long getTimeout() { return timeout; }
	public void setTimeout(long l) { timeout = l; }
	
	public class QuoteRetriever implements Runnable {
		private String symbol;
		private Float result = new Float( Float.NaN );
		
		public QuoteRetriever(String symbol) {
			this.symbol = symbol;
		}
		
		public Float getResult() {
			return result;
		}
		
		public void run() {
			HttpClient client = new HttpClient();
			try {
				HttpURL url = new HttpURL( quoteURL.toString() );
				url.setQuery( "symbol", symbol );
				
				GetMethod getMethod = new GetMethod( url.toString() );
				client.executeMethod( getMethod );
				String response = getMethod.getResponseBodyAsString();
				
				result = new Float( response );
			} catch( Exception e ) {
				System.out.println( "Error retrieving quote" );
			}
		}
		
	}
}
