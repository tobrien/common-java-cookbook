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

import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.math.stat.regression.SimpleRegression;

public class ProcessEstimator {

	private SimpleRegression regression = new SimpleRegression();
	private StopWatch stopWatch = new StopWatch();

	// Total number of units
	private int units = 0;
	
	// Number of units completed
	private int completed = 0;

	// Sample rate for regression
	private int sampleRate = 1;
	
	public ProcessEstimator( int numUnits, int sampleRate ) {
		this.units = numUnits;
		this.sampleRate = sampleRate;
	}
	
	public void start() {
		stopWatch.start();
	}
	
	public void stop() {
		stopWatch.stop();
	}

	public void unitCompleted() {
		completed++;
		
		if( completed % sampleRate == 0 ) {
			long now = System.currentTimeMillis();
			regression.addData( units - completed, stopWatch.getTime());
		}
	}
	
	public long projectedFinish() {
		return (long) regression.getIntercept();
	}
	
	public long getTimeSpent() {
		return stopWatch.getTime();
	}

	public long projectedTimeRemaining() {
		long timeRemaining = projectedFinish() - getTimeSpent();		
		return timeRemaining;
	}
	

	public int getUnits() {
		return units;
	}

	public int getCompleted() {
		return completed;
	}

}
