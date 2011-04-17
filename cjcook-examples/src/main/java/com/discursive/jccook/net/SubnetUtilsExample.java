package com.discursive.jccook.net;

import org.apache.commons.net.util.SubnetUtils;

public class SubnetUtilsExample {

	public static void main(String[] args) {
		new SubnetUtilsExample().start();
	}

	public void start() {

		// Using Classless Inter-Domain Routing (CIDR) Notation
		String subnetCidr = "192.168.1.1/24";
		SubnetUtils subnet = new SubnetUtils(subnetCidr);

		String ipAddress = "192.168.1.23";
		boolean result = subnet.getInfo().isInRange(ipAddress);
		System.out.printf("Is %s in %s? %s\n", ipAddress, subnetCidr, result);

		ipAddress = "192.168.2.13";
		result = subnet.getInfo().isInRange(ipAddress);
		System.out.printf("Is %s in %s? %s\n\n", ipAddress, subnetCidr, result);

		// Using Dot-decimal notation
		String subnetAddress = "192.168.5.130";
		String dotDecimalMask = "255.255.255.192";
		subnet = new SubnetUtils(subnetAddress, dotDecimalMask);

		ipAddress = "192.168.5.140";
		result = subnet.getInfo().isInRange(ipAddress);
		System.out.printf("Is %s in %s (netmask %s)? %s\n", ipAddress, subnetAddress,
				dotDecimalMask, result);

		ipAddress = "192.168.5.213";
		result = subnet.getInfo().isInRange(ipAddress);
		System.out.printf("Is %s in %s (netmask %s)? %s\n", ipAddress, subnetAddress,
				dotDecimalMask, result);

	}
}
