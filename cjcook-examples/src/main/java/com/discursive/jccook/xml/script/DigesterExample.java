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
package com.discursive.jccook.xml.script;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.log4j.Logger;

import com.discursive.jccook.util.LogInit;

/**
 * Include a table of the Values in DateFormatUtils
 */
public class DigesterExample {

    private static Logger logger = Logger.getLogger(DigesterExample.class);
    static {
        LogInit.init();
    }

    public static void main(String[] pArgs) throws Exception {
        DigesterExample example = new DigesterExample();
        example.testDigest();
    }

    public void testDigest() throws Exception {

        List operations = new ArrayList();

        InputStream input = getClass().getResourceAsStream("./math.xml");
        URL rules = getClass().getResource("./math-rules.xml");
        Digester digester = DigesterLoader.createDigester(rules);
        digester.push(operations);

        logger.debug("Number of operations: " + operations.size());

    }

}
