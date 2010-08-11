package com.discursive.cjcook.guava.io;

import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.Charset;

import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.common.io.OutputSupplier;

public class JoinReaders {
	public static void main(String[] args) throws Exception {
		Charset utf8 = Charset.forName("UTF-8");

		InputSupplier<InputStreamReader> rs1 = Files.newReaderSupplier(
				new File("data", "test1.txt"), utf8);
		InputSupplier<InputStreamReader> rs2 = Files.newReaderSupplier(
				new File("data", "test2.txt"), utf8);

		InputSupplier<Reader> combined = CharStreams.join(rs1, rs2);

		OutputSupplier<OutputStreamWriter> ws = Files.newWriterSupplier(
				new File("output.txt"), utf8, false);

		CharStreams.copy(combined, ws);
	}
}
