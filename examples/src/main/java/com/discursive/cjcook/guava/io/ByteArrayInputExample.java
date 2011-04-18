package com.discursive.cjcook.guava.io;

import java.util.Date;

import org.apache.commons.lang.math.RandomUtils;

import com.discursive.cjcook.proto.Checkin.PositionData;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class ByteArrayInputExample {
	public static void main(String[] args) throws Exception {
		int size = 10000;
		ByteArrayDataOutput byteOut = ByteStreams.newDataOutput();

		for (int i = 0; i < size; i++) {
			PositionData pData = PositionData.newBuilder().setVehicleId(1)
					.setTimestamp((new Date()).getTime()).setAltitude(
							RandomUtils.nextFloat()).setLatitude(1.0f)
					.setLongitude(1.0f).setSpeed(RandomUtils.nextInt(100))
					.build();
			byteOut.write(pData.toByteArray());
		}

		byte[] encodedData = byteOut.toByteArray();
		System.out.printf("%d PositionData objects encoded into %d bytes",
				size, encodedData.length);
	}
}