package com.discursive.cjcook.guava.io;

import java.io.File;
import java.nio.charset.Charset;

import com.google.common.io.Files;

public class AppendingText {

	public static void main(String[] args) throws Exception {
		File outFile = new File("output2.txt");
		Files.append( "\nThis is a test", outFile, Charset.forName("UTF-8"));
	}
}
