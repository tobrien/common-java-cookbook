package com.discursive.cjcook.guava.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.google.common.io.Closeables;
import com.google.common.io.Flushables;

public class CloseFlushExample {
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
			Flushables.flushQuietly( os );
			Closeables.closeQuietly( os );
		}
	}
}
