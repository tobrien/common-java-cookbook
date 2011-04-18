package com.discursive.cjcook.guava.io;

import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

public class ChecksumStream {
	public static void main(String[] args) throws Exception {
		InputStream test = ChecksumStream.class
				.getResourceAsStream("test.data");
		byte[] byteArray = ByteStreams.toByteArray(test);

		CRC32 crc32 = new CRC32();
		long checksum = ByteStreams.getChecksum(ByteStreams
				.newInputStreamSupplier(byteArray), crc32);
		System.out.printf("Checksum: %d", checksum);
	}
}
