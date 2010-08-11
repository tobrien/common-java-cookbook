package com.discursive.cjcook.guava.io;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang.math.RandomUtils;

import com.discursive.cjcook.proto.Checkin.PositionData;

public class ByteArrayInputExampleAlt {
	public static void main(String[] args) {
		int size = 10000;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);

		for (int i = 0; i < size; i++) {
			PositionData pData = PositionData.newBuilder().setVehicleId(1)
					.setTimestamp((new Date()).getTime()).setAltitude(
							RandomUtils.nextFloat()).setLatitude(1.0f)
					.setLongitude(1.0f).setSpeed(RandomUtils.nextInt(100))
					.build();
			try {
				dos.write(pData.toByteArray());
			} catch (IOException e) {
				// Please this is a PITA
				// Use the ByteArrayDataOutput
			}
		}

		byte[] encodedData = baos.toByteArray();
		System.out.printf("%d PositionData objects encoded into %d bytes",
				size, encodedData.length);
	}
}
