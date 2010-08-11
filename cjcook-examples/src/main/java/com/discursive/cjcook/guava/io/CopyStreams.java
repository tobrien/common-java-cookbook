package com.discursive.cjcook.guava.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.common.io.ByteStreams;

public class CopyStreams {

	public static void main(String[] args) throws IOException {
		InputStream is = CopyStreams.class.getResourceAsStream("test.data");
		OutputStream os = System.out;

		ByteStreams.copy(is, os);
	}

}
