package com.discursive.cjcook.json;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONBuilder;

public class ConvertBeantoJSON {

	public static void main(String[] args) throws Exception {
		Person person = new Person("Marshall Mathers", 37, "Detroit");

		JSONObject json = JSONObject.fromObject( person );
		System.out.printf("JSON: %s", json.toString(2));
	}
}
