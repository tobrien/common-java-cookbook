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

public class Address {

    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipcode;

    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getStreet1() {
        return street1;
    }
    public String getStreet2() {
        return street2;
    }
    public String getZipcode() {
        return zipcode;
    }

    public void setCity(String pCity) {
        city = pCity;
    }
    public void setState(String pState) {
        state = pState;
    }
    public void setStreet1(String pStreet1) {
        street1 = pStreet1;
    }
    public void setStreet2(String pStreet2) {
        street2 = pStreet2;
    }
    public void setZipcode(String pZipcode) {
        zipcode = pZipcode;
    }

}
