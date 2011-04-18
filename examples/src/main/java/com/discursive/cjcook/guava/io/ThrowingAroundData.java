package com.discursive.cjcook.guava.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Random;

import org.apache.commons.math.stat.StatUtils;

import com.google.common.io.Closeables;
import com.google.common.io.FileBackedOutputStream;

public class ThrowingAroundData {

	// Define a 200 KB threshold
	private static int THRESHOLD = 340 * 1024;

	// Define the Mean for Image Size
	private static int MEAN = 300 * 1024;

	// Define the Standard Deviation (such that 95% fall below threshold)
	private static int STDEV = Math.round( ( THRESHOLD - MEAN ) / 1.645f);

	// Define the Sample Size
	private static int SAMPLE = 2000;

	public static void main(String[] args) throws Exception {

		double[] times = new double[SAMPLE];
		double[] sizes = new double[SAMPLE];

		for (int i = 0; i < SAMPLE; i++) {
			byte[] randomData = generateRandomData();

			long t1 = System.nanoTime();
			FileBackedOutputStream os = new FileBackedOutputStream(THRESHOLD);
			//File tempFile = File.createTempFile("tmp", "tmp");
			//OutputStream os = new FileOutputStream(tempFile);
			os.write(randomData);
			Closeables.closeQuietly(os);
			long t2 = System.nanoTime();
			times[i] = (double) (t2 - t1);
			sizes[i] = randomData.length;
			
		}

		System.out.printf("Time(ns) Mean: %.2f, StdDev: %.2f, Min: %.2f, Max: %.2f\n", 
				StatUtils.mean(times) / 1.0E06,
				Math.sqrt( StatUtils.variance( times) ) / 1.0E06,
				StatUtils.min(times) / 1.0E06, 
				StatUtils.max(times) / 1.0E06);

		System.out.printf("Data(KB) Mean: %.0f, StdDev: %.0f, Min: %.0f, Max: %.0f", 
				StatUtils.mean(sizes) / 1024,
				Math.sqrt( StatUtils.variance( sizes) ) / 1024,
				StatUtils.min(sizes) / 1024, 
				StatUtils.max(sizes) / 1024);

	}

	private static byte[] generateRandomData() {
		double guassian = new Random().nextGaussian();
		int size = MEAN + (int) (guassian * STDEV);
		byte[] random = new byte[size];
		new Random().nextBytes(random);
		return random;
	}
}
