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

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealMatrixImpl;

public class SolveEquations {

	public static void main(String[] args) {

		double[][] coefficients = { { 3.0, 20.0, 89.0 },
												{ 4.0, 40.0, 298.0 },
												 { 7.0, 21.0, 0.42 } };

		double[] values = { 1324, 2999, 2039 };
		

		RealMatrix matrix = new RealMatrixImpl( coefficients );
		
		double[] answers = matrix.solve( values );

		System.out.println( "Answers: " + ArrayUtils.toString( answers ) );

		double[][] badCoefficients = { { 1, 1, 1 },
								{ 1, 1, 1 },
								{ 1, 1, 1 } };
								
		double[] badValues = { 0, 1, 3 };
		
		matrix = new RealMatrixImpl( badCoefficients );
		
		answers = matrix.solve( badValues );

		System.out.println( "Answers: " + ArrayUtils.toString( answers ) );


	}
}
