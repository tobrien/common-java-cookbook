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
package com.discursive.jccook.script.velocity.macro;

public class Person {

    private String firstName;
    private String lastName;
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setEmailAddress(String pEmailAddress) {
        emailAddress = pEmailAddress;
    }
    public void setFirstName(String pFirstName) {
        firstName = pFirstName;
    }
    public void setLastName(String pLastName) {
        lastName = pLastName;
    }

}
