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
package com.discursive.jccook.collections.predicate;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.AllPredicate;
import org.apache.commons.collections.map.PredicatedMap;

public class ImprovedPredicatedMapExample extends ValidCoachPredicate {

	Map teamMap;

	public static void main(String[] args) {
		ImprovedPredicatedMapExample example = new ImprovedPredicatedMapExample();
		example.start();
	}
	
	public void start() {
		// Create the Predicates
		PropertyPredicate teamName = new PropertyPredicate( "name" );
		PropertyPredicate coachFirstName = new PropertyPredicate( "coach.firstName" );
		PropertyPredicate coachLastName = new PropertyPredicate( "coach.lastName" );
		
			
		// Tie three Predicates together into an AllPredicate
		Predicate[] predicateArray = new Predicate[] { teamName, coachFirstName, coachLastName };
		AllPredicate valuePredicate = new AllPredicate( predicateArray );
		
		// Decorate a HashMap with a predicate on the value
		teamMap = PredicatedMap.decorate( new HashMap(), null, valuePredicate);
		
		// Manufacture some teams
		Team redSox = new Team( "Red Sox", new Coach( "Patrick", "Moloney") );
		Team yankees= new Team( "Yankees", new Coach( "David", "McGarry") );
		Team dodgers = new Team( "Dodgers", new Coach( "Nick", "Taylor") );
		Team twins = new Team( null, new Coach( "Patrick", "Moloney") );
		Team braves = new Team( "Braves", null );
		
		// The follow put calls should work fine
		teamMap.put( "RedSox", redSox );
		teamMap.put( "Yankees", yankees );
		teamMap.put( "Dodgers", dodgers );
		
		// This put should fail because the team name is null
		try {
			teamMap.put( "Twins", twins);
		} catch( IllegalArgumentException iae ) {
			System.out.println( "Twins put failed, as expected" );
		}

		// This put should fail because the coach is null
		try {
			teamMap.put( "Braves", braves);
		} catch( IllegalArgumentException iae ) {
			System.out.println( "Braves put failed, as expected" );
		}

		
	}
}
