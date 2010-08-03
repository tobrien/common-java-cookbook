package com.discursive.cjcook.proto;

import java.util.Date;

import org.apache.webdav.lib.properties.GetContentLengthProperty;

import com.discursive.cjcook.proto.Checkin.PositionData;

public class CheckinTest {

	
	public static void main(String[] args) {
		
		PositionData pData = PositionData.newBuilder()
			.setVehicleId(1)
			.setTimestamp( (new Date()).getTime() )
			.setAltitude( 0.0f )
			.setLatitude( 0.0f )
			.setLongitude( 0.0f )
			.setSpeed( 120 )
			.build();
		
		long time1 = (new Date()).getTime();
		byte[] positionBArray = pData.toByteArray();
		long time2 = (new Date()).getTime();
		
		
	}
	
}
