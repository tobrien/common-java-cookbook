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
import java.util.Date;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class PoliticalCandidate implements Comparable {

	private String lastName;
	private String firstName;
	private Date dateOfBirth;
	private BigDecimal moneyRaised;
	private State state;

	public PoliticalCandidate() {}
	public PoliticalCandidate( String lastName, String firstName, Date dateOfBirth,
											   BigDecimal moneyRaised, State state ) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.moneyRaised = moneyRaised;
		this.state = state;
	}
	
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Date getDateOfBirth() { return dateOfBirth; }
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public BigDecimal getMoneyRaised() { return moneyRaised; }
	public void setMoneyRaised(BigDecimal moneyRaised) {
		this.moneyRaised = moneyRaised;
	}
	
	public State getState() { return state; }
	public void setState(State state) {
		this.state = state;
	}
	
/*	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this);
	}*/
	
	/*
	// get/set methods are omitted for brevity...
    public String toString() {
    	return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
					.append( "lastName", lastName )
					.append( "firstName", firstName )
					.toString();
    }
    */

	/*
	// get/set methods are omitted for brevity...
    public String toString() {
    	return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
					.append( "lastName", lastName )
					.append( "firstName", firstName )
					.toString();
    }
    */
	
	/*
	// get/set methods are omitted for brevity...
    public String toString() {
    	return new ToStringBuilder(this, ToStringStyle.NO_FIELD_NAMES_STYLE)
					.append( "lastName", lastName )
					.append( "firstName", firstName )
					.toString();
    }
    */
	
	// get/set methods are omitted for brevity...
    public String toString() {
    	return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
					.append( "lastName", lastName )
					.append( "firstName", firstName )
					.toString();
    }
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
//  A compare to which mimics the behavior of equals()
    public int compareTo(Object o) {
        int compare = -1; // By default return less-than
        if( o != null && 
            PoliticalCandidate.class.isAssignableFrom( o.getClass() ) ) {
                PoliticalCandidate pc = (PoliticalCandidate) o;
                compare = (new CompareToBuilder()
                              .append(firstName, pc.firstName)
                              .append(lastName, pc.lastName)).toComparison();
        }
        return compare;
    }
	
    
	


}
