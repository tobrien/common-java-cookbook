package com.discursive.cjcook.guava.collect;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class PowerSetExample {
	public static void main(String[] args) {
		Set<Integer> integers = ImmutableSet.of(1, 2, 3, 4, 5);
		
		Set<Set<Integer>> powerSet = Sets.powerSet( integers );
		for( Set<Integer> set : powerSet ) {
			System.out.printf( "Powerset: %s\n", set );
		}
	}
}
