package com.discursive.cjcook.proto;

import java.util.Date;

import com.discursive.cjcook.proto.Checkin.PositionData;
import com.google.protobuf.InvalidProtocolBufferException;

public class CheckinTiming {

	public static void main(String[] args) throws Exception {
		
		int size = 3000000;
		
		PositionData[] pArray = new PositionData[size];
		
		long preCreate = (new Date()).getTime();
		for( int i = 0; i < size; i++ ) {
			PositionData pData = PositionData.newBuilder()
				.setVehicleId(1)
				.setTimestamp( (new Date()).getTime() )
				.setAltitude( 123.0f )
				.setLatitude( 1.0f )
				.setLongitude( 1.0f )
				.setSpeed( 120 )
				.build();
			pArray[i] = pData;
		}
		long postCreate = (new Date()).getTime();
		float createTime = 
			((float) (postCreate - preCreate) / 
					(float) size ) * 1000 * 1000;
		
		System.out.printf( "Create One PositionData %.0f ns\n", createTime);

		byte[][] encodedArray = new byte[size][];
		long preEncode = (new Date()).getTime();
		for( int i = 0; i < size; i++ ) {
			byte[] positionBArray = pArray[i].toByteArray();
			encodedArray[i] = positionBArray;
		
		}
		long postEncode = (new Date()).getTime();
		float encodeTime = 
			((float) (postEncode - preEncode) / 
					(float) size ) * 1000 * 1000;
		System.out.printf( "Encode One PositionData to byte[] %.0f ns\n", 
							encodeTime);

		PositionData[] decodedArray = new PositionData[size];
		long preDecode = (new Date()).getTime();
		for( int i = 0; i < size; i++) {
			PositionData pData = PositionData.parseFrom( encodedArray[i] );
			decodedArray[i] = pData;
		}
		long postDecode = (new Date()).getTime();
		float decodeTime = 
			((float) (postDecode - preDecode) / 
					(float) size ) * 1000 * 1000;
		System.out.printf( "Decode One PositionData from byte[] %.0f ns\n", 
							decodeTime);		
	}
}
