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

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.Predicate;

public class PropertyPredicate implements Predicate {

	private String property;
	private Object matchValue = null;

	public PropertyPredicate(String property) {
		this.property = property;
	}

	public PropertyPredicate(String property, Object matchValue) {
		this.property = property;
		this.matchValue = matchValue;
	}

	public boolean evaluate(Object object) {
		boolean propertyFound = false;
		try {
			Object value = PropertyUtils.getProperty( object, property );
			if( value != null ) {
				if( matchValue != null ) {
					propertyFound = matchValue.equals( value );					
				} else {
					propertyFound = true;
				}
			}
		} catch(Exception e) {
			// If there was an exception, the predicate returns false
		}
		return propertyFound;
	}
}
