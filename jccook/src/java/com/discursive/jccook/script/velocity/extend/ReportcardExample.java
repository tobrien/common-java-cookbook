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
package com.discursive.jccook.script.velocity.extend;

import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.discursive.jccook.util.LogInit;

/**
 * Include a table of the Values in DateFormatUtils
 */
public class ReportcardExample {

    private static Logger logger = Logger.getLogger(ReportcardExample.class);
    static {
        LogInit.init();
    }

    public static void main(String[] pArg) throws Exception {
        ReportcardExample test = new ReportcardExample();
        test.testSimpleTemplate();
    }
    public void testSimpleTemplate() throws Exception {

        VelocityEngine vEngine = new VelocityEngine();
        vEngine.setProperty(
            "velocimacro.library",
            "scripting/velocity/extend/VM_students.vm");
        vEngine.setProperty("resource.loader", "class");
        vEngine.setProperty(
            "class.resource.loader.description",
            "Classpath Loader");
        vEngine.setProperty(
            "class.resource.loader.class",
            "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        vEngine.init();
        VelocityContext context = new VelocityContext();
        context.put("results", testResults());
        context.put("stat", new StatUtil());
        StringWriter writer = new StringWriter();
        vEngine.mergeTemplate(
            "com/discursive/jccook/script/velocity/extend/results.vm",
            context,
            writer);

        logger.debug("results: " + writer.toString());
    }

    private Results testResults() {

        Results res = new Results();

        int[] scores = {
            40, 87, 95, 97, 75
        };
        res.setScores(scores);

        Student s1 = new Student();
        s1.setName("Tim O.");
        s1.setScore(40);

        Student s2 = new Student();
        s2.setName("Susan P.");
        s2.setScore(87);

        Student s3 = new Student();
        s3.setName("Rock P.");
        s3.setScore(95);

        Student s4 = new Student();
        s4.setName("Stephanie P.");
        s4.setScore(97);

        Student s5 = new Student();
        s5.setName("Federico H.");
        s5.setScore(75);

        Student[] sArray = {
            s1, s2, s3, s4, s5
        };
        res.setStudents(sArray);

        return res;
    }

}
