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

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class State {
	
	private String abbreviation;
	private String name;
	
	public State() {}
	public State( String abbreviation, String name ) {
		this.abbreviation = abbreviation;
		this.name = name;
	}
	
	public String getAbbreviation() { return abbreviation; }
	public void setAbbreviation(String abbreviation) { 
		this.abbreviation = abbreviation;	
	}
	
	public String getName() { return name; }
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this);
	}
	
}
