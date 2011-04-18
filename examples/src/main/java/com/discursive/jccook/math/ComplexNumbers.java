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

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.complex.ComplexFormat;

public class ComplexNumbers {

	public static void main(String[] args) 
	{
		Complex a = new Complex(2, 3);
		Complex b = new Complex(4, 5);
		Complex c = new Complex(0.3, 2);
		Complex e = new Complex(4, 4);
		
		Complex sum = a.add( b );
		Complex d = c.divide( sum );
		Complex f = e.multiply( d.conjugate() );
		
		System.out.println( "D is: " + ComplexFormat.formatComplex( d ) );
		System.out.println( "F is: " + ComplexFormat.formatComplex( f ) );
	
		double realF = f.getReal();
		double imD = d.getImaginary();
		double answer = realF / imD;
		
		System.out.println( "Answer: " + NumberFormat.getInstance().format( answer ) );
				
	}


}
