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
package com.discursive.jccook.lang.math;

import org.apache.commons.lang.math.Fraction;

public class FractionExample {

	public static void main(String[] args) {
		Fraction numer1 = Fraction.getFraction( 3, 4 );
		Fraction numer2 = Fraction.getFraction( 51, 3509 );
	
		Fraction numerator = numer1.multiplyBy( numer2 );
		Fraction denominator = Fraction.getFraction( 41, 59 );
	
		Fraction result = numerator.divideBy( denominator );
	
		System.out.println( "Expression as Fraction: " + result.reduce().toString() );
		System.out.println( "Expression as double: " + result.doubleValue() );
		
		Fraction test1 = Fraction.getFraction( 1, 2 );
		Fraction test2 = Fraction.getFraction( 2, 4 );
		
		System.out.println( "1/2 equals 2/4: " + test1.equals( test2 ) );
		
		double value = Fraction.getFraction( 10000, 100000 ).pow( 6 ).doubleValue();
		double reduced = Fraction.getFraction( 10000, 100000 ).reduce().pow( 6 ).doubleValue();
		
		System.out.println( "Fraction to pow 6 without reduction: " + value );
	    System.out.println( "Fraction to pow 6 with reduction: " + reduced );
	}
}
