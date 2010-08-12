package com.discursive.cjcook.guava.collect;

import java.util.Set;

import com.google.common.collect.Sets;

public class SetUnionExample {
	public static void main(String[] args) {
		Set<String> names1 = Sets.newHashSet();
		names1.add( "Tim" );
		names1.add( "Tom" );
		names1.add( "Ted" );

		Set<String> names2 = Sets.newHashSet();
		names2.add( "Susan" );
		names2.add( "Tony" );
		names2.add( "Ted" );
		
		Set<String> union = Sets.union( names1, names2 );
		for( String name : union ) {
			System.out.printf( "%s\n", name);
		}
	}	
}
