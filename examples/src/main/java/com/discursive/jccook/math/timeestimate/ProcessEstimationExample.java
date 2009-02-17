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
package com.discursive.jccook.math.timeestimate;

import org.apache.commons.lang.math.RandomUtils;

public class ProcessEstimationExample {

	private ProcessEstimator estimate;

	public static void main(String[] args) {
		ProcessEstimationExample example = new ProcessEstimationExample();
		example.begin();
	}

	public void begin() {
		estimate = new ProcessEstimator( 10000, 100 );
		estimate.start();
		
		for( int i = 0; i < 10000; i++ ) {
			// Print status every 1000 items
			printStatus(i);
		
			performLengthyProcess();
			
			estimate.unitCompleted();
		}
		
		estimate.stop();
		
		System.out.println( "Completed " + estimate.getUnits() + " in " + 
									   Math.round( estimate.getTimeSpent() / 1000 ) + " seconds." );
	}
	
	private void printStatus(int i) {
		if( i % 1000 == 0 ) {
			System.out.println( "Completed: " + estimate.getCompleted() + " of " + estimate.getUnits() );
			
			System.out.println( "\tTime Spent: " + Math.round( estimate.getTimeSpent() / 1000) + " sec" +
											", Time Remaining: " + Math.round( estimate.projectedTimeRemaining() / 1000) + " sec" );
		}
	}
	
	private void performLengthyProcess() {
		try {
			Thread.sleep(RandomUtils.nextInt(10));
		} catch( Exception e ) {}
	}
}