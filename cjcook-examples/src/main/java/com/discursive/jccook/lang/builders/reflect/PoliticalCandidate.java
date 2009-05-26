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
package com.discursive.jccook.lang.builders.reflect;
// START lang-ex-1
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.discursive.jccook.lang.builders.State;

public class PoliticalCandidate  {

	private String lastName;
	private String firstName;
	private Date dateOfBirth;
	private BigDecimal moneyRaised;
	private State state;

	public PoliticalCandidate() {}
	
	// get/set methods are omitted for brevity...
	
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this);
	}

}
// END lang-ex-1
