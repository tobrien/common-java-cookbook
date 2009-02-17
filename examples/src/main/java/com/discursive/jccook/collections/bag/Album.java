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
package com.discursive.jccook.collections.bag;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Album {

	private String band;
	private String title;
	
	public Album() {}
	
	public Album( String band, String title ) {
		this.band = band;
		this.title = title;
	}
	
	public String getBand() { return band; }
	public String getTitle() { return title; }

	public void setBand(String string) { band = string; }
	public void setTitle(String string) { title = string; }
	
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals( this, obj );
	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode( this );
	}

}
