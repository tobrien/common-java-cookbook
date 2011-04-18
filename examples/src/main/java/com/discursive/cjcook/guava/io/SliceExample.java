package com.discursive.cjcook.guava.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;

public class SliceExample {
	public static void main(String[] args) throws IOException {
		InputSupplier<FileInputStream> fileIn = Files
				.newInputStreamSupplier(new File("data", "large.txt"));
		InputSupplier<InputStream> slicedStream = ByteStreams.slice( fileIn, 10, 1000 );
		byte[] data = ByteStreams.toByteArray( slicedStream );
	}
}
