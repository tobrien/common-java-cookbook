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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.map.TypedMap;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;

public class XPathPredicate implements Predicate {
	
	private String path;
	private Map variables = TypedMap.decorate( new HashMap(), String.class, Object.class);

	public XPathPredicate(String path) {
		this.path = path;
	}

	public XPathPredicate(String path, Map variables) {
		this.path = path;
		this.variables.putAll( variables );
	}

	public boolean evaluate(Object object) {
		boolean matches = false;
		JXPathContext context = JXPathContext.newContext(object);
		if( variables != null ) {
			populateVariables( context );
		}
		try {
			Object value = context.getValue( path );
			if( value != null ) {
				matches = true;
			}
		} catch( JXPathException e ) {
			// If this happens there is no match
		}
		return matches;
	}

	private void populateVariables(JXPathContext context) {
		Set keys = variables.keySet();
		Iterator keyIter = keys.iterator();
		while( keyIter.hasNext() ) {
			String key = (String) keyIter.next();
			context.getVariables().declareVariable( key, variables.get( key ) );
		}
	}

}
