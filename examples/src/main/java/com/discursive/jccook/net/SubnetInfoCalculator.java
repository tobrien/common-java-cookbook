package com.discursive.jccook.net;

import org.apache.commons.net.util.SubnetUtils;

public class SubnetInfoCalculator {
	
	public static void main(String[] args) {
		new SubnetInfoCalculator().start();
	}
	
	public void start() {
		SubnetUtils subnet = new SubnetUtils("164.232.43.23/26");
		System.out.printf( "%s\n", subnet.getInfo() );
	}

}
