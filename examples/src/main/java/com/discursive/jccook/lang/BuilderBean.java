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
package com.discursive.jccook.lang;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class BuilderBean implements Comparable {

    private String prop1;
    private String prop2;

    public String getProp1() {
        return prop1;
    }
    public void setProp1(String pProp1) {
        prop1 = pProp1;
    }

    public String getProp2() {
        return prop2;
    }
    public void setProp2(String pProp2) {
        prop2 = pProp2;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public boolean equals(Object pObject) {
        return EqualsBuilder.reflectionEquals(this, pObject);
    }

    public int compareTo(Object pObject) {
        return CompareToBuilder.reflectionCompare(this, pObject);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
