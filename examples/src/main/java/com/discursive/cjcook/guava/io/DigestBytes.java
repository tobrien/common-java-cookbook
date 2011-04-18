package com.discursive.cjcook.guava.io;

import java.io.InputStream;
import java.security.MessageDigest;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import org.apache.commons.codec.binary.Hex;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

public class DigestBytes {
	public static void main(String[] args) throws Exception {
		InputStream test = DigestBytes.class.getResourceAsStream("test.data");
		byte[] byteArray = ByteStreams.toByteArray(test);

		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		byte[] digest = ByteStreams.getDigest(ByteStreams
				.newInputStreamSupplier(byteArray), sha);
		for (byte b : digest)
			System.out.printf("%02x:", 0xFF & b);
	}
}
