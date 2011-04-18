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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;


public class FTPExample {
	public static void main(String[] args) throws IOException {
		new FTPExample().start();
	}
	
	public void start() throws IOException {

		FTPClient client = new FTPClient();
		OutputStream outStream = null;

		try {
            client.connect( "ftp.ibiblio.org" );
			client.login( "anonymous", "" );
		
			String remoteFile = "/pub/micro/commodore/schematics/computers/c64/c64bus.gif";
			outStream = new FileOutputStream( "c64bus.gif" );

			client.retrieveFile( remoteFile, outStream );
		} catch(IOException ioe) {
			System.out.println( "Error communicating with FTP server." );
		} finally {
			IOUtils.closeQuietly( outStream );
			try {
                client.disconnect();
            } catch (IOException e) {
            	System.out.println( "Problem disconnecting from FTP server" );
            }
		}


        secondExample();

		

	}

    private void secondExample()
        throws SocketException, IOException {
        FTPClient client = new FTPClient();
        client.connect( "ftp.ibiblio.org" );
        client.login( "anonymous", "" );
        
        String remoteDir = "/pub/mirrors/apache/jakarta/ecs/binaries";
        
        FTPFile[] remoteFiles = client.listFiles( remoteDir );
        
        System.out.println( "Files in " + remoteDir );
        
        for (int i = 0; i < remoteFiles.length; i++) {
        	String name = remoteFiles[i].getName();
        	long length = remoteFiles[i].getSize();
        	String readableLength = FileUtils.byteCountToDisplaySize( length );
        
            System.out.println( name + ":\t\t" + readableLength );
        }
        
        client.disconnect();
    }
}
