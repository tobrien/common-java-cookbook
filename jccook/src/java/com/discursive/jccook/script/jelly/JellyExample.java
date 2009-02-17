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
package com.discursive.jccook.script.jelly;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Vector;

import org.apache.commons.jelly.JellyContext;
import org.apache.commons.jelly.XMLOutput;
import org.apache.log4j.Logger;

import com.discursive.jccook.util.LogInit;

/**
 * Include a table of the Values in DateFormatUtils
 */
public class JellyExample {

    private static Logger logger = Logger.getLogger(JellyExample.class);
    static {
        LogInit.init();
    }

    public static void main(String[] pArgs) throws Exception {
        JellyExample test = new JellyExample();
        test.testSimpleScript();
    }

    public void testSimpleScript() throws Exception {

        OutputStream output = new FileOutputStream("demopage.html");
        JellyContext context = new JellyContext();

        context.setVariable("name", "Tim O'Brien");
        context.setVariable("background", "blue");
        context.setVariable("url", "http://www.google.com");
        context.setVariable("hobbies", new Vector());

        XMLOutput xmlOutput = XMLOutput.createXMLOutput(output);
        context.runScript(getClass().getResource("template.xml"), xmlOutput);
        xmlOutput.flush();
    }

}
