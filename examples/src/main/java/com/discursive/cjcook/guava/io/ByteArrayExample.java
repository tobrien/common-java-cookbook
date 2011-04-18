package com.discursive.cjcook.guava.io;

import java.util.Date;

import org.apache.commons.lang.math.RandomUtils;

import com.discursive.cjcook.proto.Checkin.PositionData;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class ByteArrayExample {
	public static void main(String[] args) throws Exception {
		int size = 10000;
		ByteArrayDataOutput byteOut = ByteStreams.newDataOutput();

		for( int i = 0; i < size; i++ ) {
			byteOut.writeDouble( RandomUtils.nextDouble() );
			byteOut.writeInt( RandomUtils.nextInt() );
		}
		
		ByteArrayDataInput input = ByteStreams.newDataInput( byteOut.toByteArray() );
		for( int i = 0; i < size; i++ ) {
			input.readInt();
			input.readDouble();
		}
	}
}