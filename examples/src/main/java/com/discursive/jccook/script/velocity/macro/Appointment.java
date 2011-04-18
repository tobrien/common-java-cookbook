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

public class Appointment {

    private String id;
    private String date;
    private String startTime;
    private String endTime;
    private Organization organization;
    private Person volunteer;
    private Location location;

    public String getDate() {
        return date;
    }
    public String getEndTime() {
        return endTime;
    }
    public String getId() {
        return id;
    }
    public Location getLocation() {
        return location;
    }
    public Organization getOrganization() {
        return organization;
    }
    public String getStartTime() {
        return startTime;
    }
    public Person getVolunteer() {
        return volunteer;
    }

    public void setDate(String pDate) {
        this.date = pDate;
    }
    public void setEndTime(String pEndTime) {
        endTime = pEndTime;
    }
    public void setId(String pId) {
        id = pId;
    }
    public void setLocation(Location pLocation) {
        this.location = pLocation;
    }
    public void setOrganization(Organization pOrganization) {
        this.organization = pOrganization;
    }
    public void setStartTime(String pStartTime) {
        startTime = pStartTime;
    }
    public void setVolunteer(Person pPerson) {
        volunteer = pPerson;
    }

}
