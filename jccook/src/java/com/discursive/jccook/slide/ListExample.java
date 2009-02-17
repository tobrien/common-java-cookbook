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
import java.util.Date;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.webdav.lib.WebdavResource;

public class ListExample {

	public static void main(String[] args) throws HttpException, IOException {
		String url = "http://www.discursive.com/jccook/dav/";
		Credentials credentials =
			new UsernamePasswordCredentials("davuser", "davpass");

		// List resources in top directory
		WebdavResource resource = new WebdavResource(url, credentials);
		WebdavResource[] resources = resource.listWebdavResources();
		System.out.println( "type  name           size    type                   modified");
		System.out.println( "--------------------------------------------------------------------");
		for( int i = 0; i < resources.length; i++ )	{
			WebdavResource item = resources[i];
			String type;
			if( item.isCollection() ) {
				type = "dir";
			} else {
				type = "file";
			}
			System.out.print( StringUtils.rightPad( type, 6 ) );
			System.out.print( StringUtils.rightPad( item.getName(), 15 ) );
			System.out.print( StringUtils.rightPad( item.getGetContentLength() + "", 8 ) );
			System.out.print( StringUtils.rightPad( item.getGetContentType(), 23 ) );
			Date lastMod = new Date( item.getGetLastModified() );
			System.out.print( StringUtils.rightPad( FastDateFormat.getInstance().format( lastMod ), 25 ));
			System.out.print( "\n" );
		}
	}
}
