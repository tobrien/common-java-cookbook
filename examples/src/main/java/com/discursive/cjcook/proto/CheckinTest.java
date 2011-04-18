package com.discursive.cjcook.proto;

import java.util.Date;

import org.apache.webdav.lib.properties.GetContentLengthProperty;

import com.discursive.cjcook.proto.Checkin.PositionData;
import com.google.protobuf.InvalidProtocolBufferException;

public class CheckinTest {

	public static void main(String[] args) throws Exception {

		// Create a new PositionData Message
		PositionData pData = PositionData.newBuilder().setVehicleId(1)
				.setTimestamp((new Date()).getTime()).setAltitude(0.0f)
				.setLatitude(0.0f).setLongitude(0.0f).setSpeed(120).build();

		// Convert the PositionData Message to a Byte Array
		byte[] array = pData.toByteArray();
		System.out.printf("Position Data message %d bytes", array.length);

		// Parse the Byte Array into a PositionData message
		PositionData parsed = PositionData.parseFrom(array);

	}

}
