package com.discursive.cjcook.guava.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.common.io.OutputSupplier;

public class JoinFiles {
	public static void main(String[] args) throws Exception {

		InputSupplier<FileInputStream> is = Files
				.newInputStreamSupplier(new File("data", "test1.txt"));
		InputSupplier<FileInputStream> is2 = Files
				.newInputStreamSupplier(new File("data", "test2.txt"));

		InputSupplier<InputStream> combined = ByteStreams.join(is, is2);
		OutputSupplier<FileOutputStream> os = Files.newOutputStreamSupplier(
				new File("output1.data"), false);
		ByteStreams.copy(combined, os);

	}

}
