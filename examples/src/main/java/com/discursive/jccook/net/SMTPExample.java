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
import java.io.Writer;
import java.net.SocketException;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;


public class SMTPExample {
	public static void main(String[] args) throws SocketException, IOException {
		new SMTPExample().start();
	}
	
	public void start() throws SocketException, IOException {
		SMTPClient client = new SMTPClient();
		client.connect("www.discursive.com");
		int response = client.getReplyCode();
		if( SMTPReply.isPositiveCompletion( response ) ) {
			client.setSender( "tobrien@discursive.com" );
			client.addRecipient( "tobrien@iesabroad.org" );
			Writer message = client.sendMessageData();
			message.write("This is a test message" );
			message.close();
			boolean success = client.completePendingCommand();
			if( success ) {
				System.out.println( "Message sent" );				
			}
		} else {
			System.out.println( "Error communicating with SMTP server" );
		}
		client.disconnect();
	}

}
