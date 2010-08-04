package com.discursive.cjcook.json;

import java.util.Date;

import net.sf.json.JSONObject;

public class JSONTiming {

	public static void main(String[] arg) {

		int size = 500000;

		PositionData[] pArray = new PositionData[size];

		long preCreate = (new Date()).getTime();
		for (int i = 0; i < size; i++) {
			PositionData pData = new PositionData();
			pData.setVehicleId(1);
			pData.setTimestamp((new Date()).getTime());
			pData.setAltitude(123.0f);
			pData.setLatitude(1.0f);
			pData.setLongitude(1.0f);
			pData.setSpeed(120);
			pArray[i] = pData;
		}
		long postCreate = (new Date()).getTime();
		float createTime = ((float) (postCreate - preCreate) / (float) size) * 1000 * 1000;

		System.out.printf("Create One PositionData %.0f nanoseconds\n",
				createTime);

		String[] encodedArray = new String[size];
		long preEncode = (new Date()).getTime();
		for (int i = 0; i < size; i++) {
			JSONObject obj = JSONObject.fromObject(pArray[i]);
			String encoded = obj.toString();
			encodedArray[i] = encoded;

		}
		long postEncode = (new Date()).getTime();
		float encodeTime = ((float) (postEncode - preEncode) / (float) size) * 1000;
		System.out.printf(
				"Encode One PositionData to String %.0f microseconds\n",
				encodeTime);

		PositionData[] decodedArray = new PositionData[size];
		long preDecode = (new Date()).getTime();
		for (int i = 0; i < size; i++) {
			JSONObject obj = JSONObject.fromObject( encodedArray[i] );
			PositionData pData = (PositionData) JSONObject.toBean(obj,
					PositionData.class);
			decodedArray[i] = pData;
		}
		long postDecode = (new Date()).getTime();
		float decodeTime = ((float) (postDecode - preDecode) / (float) size) * 1000;
		System.out.printf("Decode One PositionData from String %.0f microseconds\n",
				decodeTime);

	}
}
