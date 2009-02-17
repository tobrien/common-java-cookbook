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
package com.discursive.jccook.script.velocity.simple;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.discursive.jccook.util.LogInit;

/**
 * Include a table of the Values in DateFormatUtils
 */
public class SimpleExample {

    private static Logger logger = Logger.getLogger(SimpleExample.class);
    static {
        LogInit.init();
    }

    public static void main(String[] pArgs) throws Exception {
        SimpleExample velocityTest = new SimpleExample();
        velocityTest.testSimpleTemplate();
        velocityTest.testSubscription();
    }

    public void testSimpleTemplate() throws Exception {

        Velocity.init();
        VelocityContext context = new VelocityContext();
        context.put("subscription", testSubscription());
        StringWriter writer = new StringWriter();
        Reader reader =
            new InputStreamReader(getClass().getResourceAsStream("renew.vm"));
        Velocity.evaluate(context, writer, "test", reader);

        logger.debug("renew: " + writer.toString());
    }

    private Subscription testSubscription() {
        // Create Dummy Subscription
        Subscription sub = new Subscription();
        sub.setEndDate("July 23, 2005");

        Customer cust = new Customer();
        cust.setId("AD352CFF");
        cust.setFirstName("Tony");
        sub.setCustomer(cust);

        Magazine mag = new Magazine();
        mag.setTitle("Scientific American");
        mag.setBaseUrl("http://www.sciam.com");
        sub.setMagazine(mag);

        return sub;
    }

}
