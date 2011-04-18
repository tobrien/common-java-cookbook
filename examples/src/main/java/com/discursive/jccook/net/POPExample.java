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
package com.discursive.jccook.net;

import java.io.IOException;
import java.io.Reader;
import java.net.SocketException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;


public class POPExample {
	
	public static void main(String[] args) throws SocketException, IOException {
		new POPExample().start();
	}
	
	public void start() throws SocketException, IOException {
		POP3Client client = new POP3Client();
		client.connect("www.discursive.com");
		client.login("tobrien@discursive.com", "******");
		
		POP3MessageInfo[] messages = client.listMessages();
		for (int i = 0; i < 5; i++) {
			int messageNum = messages[i].number;
            System.out.println( "Message number: " + messageNum );
            Reader reader = client.retrieveMessageTop( messageNum, 10 );
            System.out.println( "Message:\n" + IOUtils.toString( reader ) );
            IOUtils.closeQuietly( reader );
        }
        
        client.logout();
        client.disconnect();
	}

}
