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
package com.discursive.jccook.lang.builders;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ToStringExample {

    public static void main(String[] pArgs) throws Exception {

		// Create a State
		State va = new State( "VA", "Virginia");

		// Create a Birth Date
		Calendar calendar = new GregorianCalendar();
		calendar.set( Calendar.YEAR, 1743 );
		calendar.set( Calendar.MONTH, Calendar.APRIL );
		calendar.set( Calendar.DAY_OF_MONTH, 13 );
		Date dob = calendar.getTime();

		BigDecimal moneyRaised = new BigDecimal( 293829292.93 );		

		// Create a Political Candidate
		PoliticalCandidate candidate = 
			new PoliticalCandidate( "Jefferson", "Thomas", dob, moneyRaised, va );
		
		System.out.println( candidate );

		// Create a Political Candidate
		PoliticalCandidate candidate2 = 
			new PoliticalCandidate( "Jefferson", "Martha", null, null, null );

		// Create a Political Candidate
		PoliticalCandidate candidate3 = 
			new PoliticalCandidate( "Jefferson", "Martha", dob, null, va );

		System.out.println( "Two Jeffersons are still different (should be > 0): " + candidate.compareTo( candidate2 ) );
		System.out.println( "Two Jeffersons are still different (should be < 0): " + candidate2.compareTo( candidate ) );
		System.out.println( "Two Martha Js are the same (should be zero): " + candidate2.compareTo( candidate3 ) );
		
    }


}
