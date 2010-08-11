package com.discursive.cjcook.guava.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import com.google.common.io.CountingInputStream;
import com.google.common.io.CountingOutputStream;

public class MeteredExample {

	public static void main(String[] args) throws Exception {
		InputStream fis = new FileInputStream( new File("data", "large.txt") );
		CountingInputStream cis = new CountingInputStream( fis );
		
		while( cis.read() != -1 ) {
			long bytesRead = cis.getCount();
			if( bytesRead % 50 == 0 ) {
				System.out.printf( "Read %d bytes...\n", bytesRead );
			}
		}
		
		OutputStream fos = new FileOutputStream( new File("output.dat" ) );
		CountingOutputStream cos = new CountingOutputStream( fos );
		String testString = "TEST STRING";
		cos.write( testString.getBytes( Charset.defaultCharset() ) );
		System.out.printf( "Just wrote %d bytes to output.dat", cos.getCount() );
		
	}
}
