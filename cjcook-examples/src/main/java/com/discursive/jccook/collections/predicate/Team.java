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

public class Team {
	private String name;
	private Coach coach;

	public Team() {}
	public Team(String name, Coach coach) {
		this.name = name;
		this.coach = coach;
	}
	
	public Coach getCoach() { return coach; }
	public String getName() { return name; }

	public void setCoach(Coach coach) { this.coach = coach; }
	public void setName(String string) { name = string; }

}
