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

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.discursive.jccook.util.LogInit;

/**
 * Include a table of the Values in DateFormatUtils
 */
public class MailExample {

    private static Logger logger = Logger.getLogger(MailExample.class);
    static {
        LogInit.init();
    }

    public static void main(String[] pArgs) throws Exception {
        MailExample velocityTest = new MailExample();
        velocityTest.testSimpleTemplate();
        velocityTest.testAppointment();
    }

    public void testSimpleTemplate() throws Exception {

        VelocityEngine vEngine = new VelocityEngine();
        vEngine.init();
        VelocityContext context = new VelocityContext();
        context.put("appointment", testAppointment());
        StringWriter writer = new StringWriter();
        Reader reader =
            new InputStreamReader(
                getClass().getResourceAsStream("organize.vm"));
        vEngine.evaluate(context, writer, "test", reader);

        logger.debug("organize: " + writer.toString());

    }

    private Appointment testAppointment() {

        // Create Dummy Appointment
        Appointment appt = new Appointment();
        appt.setId("A3D54");
        appt.setStartTime("9 AM");
        appt.setEndTime("2 PM");
        appt.setDate("9/13/03");

        // Create Dummy Organization
        Organization org = new Organization();
        org.setId("5DD2");
        org.setBaseUrl("http://www.organize.com/");
        org.setEmail("scheduling@organize.com");

        Person orgPres = new Person();
        orgPres.setFirstName("Brishen");
        orgPres.setLastName("R.");
        orgPres.setEmailAddress("brishenr@organize.com");
        org.setPresident(orgPres);

        Address orgAddr = new Address();
        orgAddr.setStreet1("201 N. 2nd Street");
        orgAddr.setStreet2("Suite 201");
        orgAddr.setCity("Jersey City");
        orgAddr.setState("NJ");
        orgAddr.setZipcode("20232");
        org.setAddress(orgAddr);

        appt.setOrganization(org);

        // Create a Dummy Volunteer
        Person volunteer = new Person();
        volunteer.setEmailAddress("johns@space.com");
        volunteer.setFirstName("John");
        volunteer.setLastName("S.");

        appt.setVolunteer(volunteer);

        // Create a Dummy Location
        Location location = new Location();
        location.setId("FD1B");
        location.setName("Boston Homeless Veterans Shelter");

        Address locAddr = new Address();
        locAddr.setStreet1("14 Court Street");
        locAddr.setStreet2("Apt. #2E");
        locAddr.setCity("Boston");
        locAddr.setState("MA");
        locAddr.setZipcode("01102");
        location.setAddress(locAddr);

        appt.setLocation(location);

        return appt;
    }

}
