package com.discursive.cjcook.guava.io;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;

import com.google.common.io.ByteStreams;
import com.google.common.io.Closeables;
import com.google.common.io.Files;
import com.google.common.io.Flushables;
import com.google.common.io.OutputSupplier;

public class CloseFlushExample3 {
	public static void main(String[] args) {
		OutputSupplier os = Files.newOutputStreamSupplier(
				new File("data", "output.txt"));
		byte magnificentByte = 1;
		try {
			ByteStreams.write(new byte[] { magnificentByte }, os);
		} catch (IOException e) {
			// Problem writing to file.
		}
		Flushables.flushQuietly((Flushable) os);
		Closeables.closeQuietly((Closeable) os);
	}
}
