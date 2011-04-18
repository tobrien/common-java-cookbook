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
package com.discursive.jccook.math;

import java.text.NumberFormat;

import org.apache.commons.math.MathException;
import org.apache.commons.math.stat.regression.SimpleRegression;

public class SimpleRegressionExample {

	public static void main(String[] args) throws MathException {

		SimpleRegression sr = new SimpleRegression();

		// Add data points 		
		sr.addData( 0, 0 );
		sr.addData( 1, 1.2 );
		sr.addData( 2, 2.6 );
		sr.addData( 3, 3.2 );
		sr.addData( 4, 4 );
		sr.addData( 5, 5 );
		
		NumberFormat format = NumberFormat.getInstance();
		
		// Print the value of y when line intersects the y axis
		System.out.println( "Intercept: " + format.format( sr.getIntercept() ) );
		
		// Print the number of data points
		System.out.println( "N: " + sr.getN() );

		// Print the Slope and the Slop Confidence
		System.out.println( "Slope: " + format.format( sr.getSlope() ) );
		System.out.println( "Slope Confidence: " + format.format( sr.getSlopeConfidenceInterval() ) );

		// Print RSquare a measure of relatedness
		System.out.println( "RSquare: " + format.format( sr.getRSquare() ) );

		sr.addData( 400, 100 );
		sr.addData( 300, 105 );
		sr.addData( 350, 70 );
		sr.addData( 200, 50 );
		sr.addData( 150, 300 );
		sr.addData( 50, 500 );
		
		System.out.println( "Intercept: " + format.format( sr.getIntercept() ) );
		System.out.println( "N: " + sr.getN() );
		System.out.println( "Slope: " + format.format( sr.getSlope() ) );
		System.out.println( "Slope Confidence: " + format.format( sr.getSlopeConfidenceInterval() ) );
		System.out.println( "RSquare: " + format.format( sr.getRSquare() ) );

		
	}
}
