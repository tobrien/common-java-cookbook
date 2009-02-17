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
package com.discursive.jccook.xml.jxpath;

import org.apache.commons.jxpath.JXPathContext;


public class TeamExample {
	public static void main(String[] args) throws Exception {
		new TeamExample().start();
	}
	
	public void start() throws Exception {
		League league = new League();

		Team team = new Team();
		league.getTeams().add( team );
		
		Person coach = new Person();
		coach.setFirstName( "Coach Bob" );
		team.setCoach( coach );
		
		Person player1 = new Person();
		player1.setFirstName( "Player Charlie" );
		team.getPlayers().add( player1 );

		Person player2 = new Person();
		player2.setFirstName( "Player Ted" );
		team.getPlayers().add( player2 );

		Person player3 = new Person();
		player3.setFirstName( "Player Bart" );
		team.getPlayers().add( player3 );

		Team team2 = new Team();
		league.getTeams().add( team2 );
		
		Person coach2 = new Person();
		coach2.setFirstName( "Coach Susan" );
		team2.setCoach( coach2 );
		
		Person player4 = new Person();
		player4.setFirstName( "Player Jim" );
		team2.getPlayers().add( player4 );

        JXPathContext context = JXPathContext.newContext( league );
        System.out.println( "** Retrieve the first name of Ted's coach");
        Object value = context.getValue( "teams/players[firstName = 'Player Ted']/../coach/firstName" );
        System.out.println( value );

        context = JXPathContext.newContext( league );
        System.out.println( "** Retrieve the players on Coach Susan's team");
        value = context.getValue( "teams/coach[firstName = 'Coach Susan']/../players" );
        System.out.println( value );
}

}
