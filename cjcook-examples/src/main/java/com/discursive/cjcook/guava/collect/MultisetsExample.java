package com.discursive.cjcook.guava.collect;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import com.google.common.collect.Multiset.Entry;

public class MultisetsExample {
	public static void main(String args[]) {

		PrintStream out = System.out;
		Multiset<String> multiset = HashMultiset.create();

		multiset.add("Red Ball", 5);
		multiset.add("Yellow Ball", 10);
		multiset.add("Blue Ball", 20);

		out.printf("Multiset #1: %s\n", multiset);

		out.printf("Multiset #1 contains a Red Ball? %s\n", multiset
				.contains("Red Ball"));
		out.println("Removing Five Red Balls from Multiset #1\n");
		
		multiset.remove("Red Ball", 5);

		out.printf("Multiset contains a Red Ball? %s\n", multiset
				.contains("Red Ball"));

		Multiset<String> multiset2 = TreeMultiset.create();
		multiset2.add("Blue Ball", 20);
		multiset2.add("Yellow Ball", 10);

		out.printf("\nMultiset #1: %s", multiset);
		out.printf("\nMultiset #2: %s", multiset2);
		out.printf("\nMultiset #1 and #2 are equal? %s", multiset
				.equals(multiset2));

		out.println("\n\nRemoving One Blue Ball from multiset2");
		multiset2.remove("Blue Ball");

		out.printf("\nMultiset #1: %s", multiset);
		out.printf("\nMultiset #2: %s", multiset2);
		out.printf("\nMultiset #1 and #2 are equal? %s", multiset
				.equals(multiset2));

	}
}
