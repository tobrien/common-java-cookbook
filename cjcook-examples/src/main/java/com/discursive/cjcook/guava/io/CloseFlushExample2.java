package com.discursive.cjcook.guava.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CloseFlushExample2 {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File("data", "output.txt"));
			
			// Do something fantastic with this file!!!
			// etc.
			byte magnificentByte = 1;
			os.write( magnificentByte );
		} catch (FileNotFoundException fnfe) {
			// Do something about this file not being found.
		} catch(IOException ioe) {
			// Egad, there's been an exception! Do something!!!
		} finally {
			try {
				if (os != null) {
					os.flush();
					os.close();
				}
			} catch (IOException e) {
				// Ok, what are you going to do now?
			}
		}
	}
}
