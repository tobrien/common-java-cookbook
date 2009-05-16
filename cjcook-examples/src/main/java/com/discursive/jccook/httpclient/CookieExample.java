package com.discursive.jccook.httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;


public class CookieExample {

	public static void main(String[] args) throws HttpException, IOException {
		HttpClient client = new HttpClient();
	
		System.out.println( "Making Request without Cookie: " );
		makeRequest(client);
			
		System.out.println( "Making Request with Cookie: " );
		Cookie cookie = new Cookie(".discursive.com", "test_cookie", "hello", "/", null, false );
		client.getState().addCookie( cookie );
		makeRequest(client);
	}

	private static void makeRequest(HttpClient client)
		throws IOException, HttpException {
		String url = "http://www.discursive.com/cgi-bin/jccook/cookie_test.cgi";
		HttpMethod method = new GetMethod( url );
		client.executeMethod( method );
		String response = method.getResponseBodyAsString();
		System.out.println( response );
		method.releaseConnection();
		method.recycle();
	}

}
