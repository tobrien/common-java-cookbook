/* 
 * ========================================================================
 * 
 * Copyright 2005 Tim O'Brien.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * ========================================================================
 */
package com.discursive.jccook.lang;

import java.text.NumberFormat;

import org.apache.commons.lang.time.StopWatch;

public class StopWatchExample {

	StopWatch clock = new StopWatch();

	public static void main(String[] args) {
		StopWatchExample example = new StopWatchExample();
		example.start();
	}
	
	private void start() {
		NumberFormat format = NumberFormat.getInstance();
		
		System.out.println( "How long does it take to take the sin of 0.34 ten million times?" );
		clock.start();
		for( int i = 0; i < 100000000; i++ ) {
			Math.sin( 0.34 );
		}
		clock.stop();

		System.out.println( "It takes " + clock.getTime() +
									  " milliseconds" );

		System.out.println( "How long does it take to multiply 2 doubles one billion times?" );
		clock.reset();
		clock.start();
		for( int i = 0; i < 1000000000; i++) {
			double result = 3423.2234 * 23e-4;
		}
		clock.stop();
		System.out.println( "It takes " + clock.getTime() + " milliseconds." );

		System.out.println( "How long does it take to add 2 ints one billion times?" );
		clock.reset();
		clock.start();
		for( int i = 0; i < 1000000000; i++) {
			int result = 293842923 + 33382922;
		}
		clock.stop();
		System.out.println( "It takes " + clock.getTime() + " milliseconds." );
		

		System.out.println( "Testing the split() method." );
		clock.reset();
		clock.start();
		try { Thread.sleep(1000); } catch( Exception e ) {}
		clock.split();
		System.out.println( "Split Time after 1 sec: " + clock.getTime() );
		try { Thread.sleep(1000); } catch( Exception e ) {}
		System.out.println( "Split Time after 2 sec: " + clock.getTime() );
		clock.unsplit();
		try { Thread.sleep(1000); } catch( Exception e ) {}
		System.out.println( "Time after 3 sec: " + clock.getTime() );
		
	}
}
