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
package com.discursive.jccook.template.freemarker;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.discursive.jccook.util.LogInit;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;

/**
 * Include a table of the Values in DateFormatUtils
 */
public class FreemarkerExample {

    private static Logger logger = Logger.getLogger(FreemarkerExample.class);
    static {
        LogInit.init();
    }

    public static void main(String[] pArgs) throws Exception {
        FreemarkerExample example = new FreemarkerExample();
        example.testSimpleTemplate();
    }

    public void testSimpleTemplate() throws Exception {

        Configuration cfg = Configuration.getDefaultConfiguration();
        cfg.setTemplateLoader(new ClassTemplateLoader(getClass()));
        cfg.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);

        logger.debug("Template Loader: " + cfg.getTemplateLoader());

        Map root = new HashMap();
        root.put("enrollment", testEnrollment());

        Template template = cfg.getTemplate("template.ftl");

        StringWriter writer = new StringWriter();
        template.process(root, writer);

        logger.debug("output: \n" + writer.toString());

    }

    private Enrollment testEnrollment() {

        Enrollment enroll = new Enrollment();
        enroll.setSection(2);

        Course course = new Course();
        course.setDept("ECON");
        course.setNum(201);
        course.setName("Macroeconomics");
        course.setProfessor("Elzinger K.");
        enroll.setCourse(course);

        Student stud = new Student();
        stud.setFirstName("Stefan");
        stud.setLastName("Winz");
        enroll.setStudent(stud);

        List exams = new ArrayList();

        Calendar cal = new GregorianCalendar(2003, 1, 5);

        Exam e1 = new Exam();
        e1.setName("T01");
        e1.setDate(cal.getTime());
        e1.setScore(90.0);
        e1.setWeight(1.00);
        exams.add(e1);

        cal.add(Calendar.WEEK_OF_YEAR, 2);
        Exam e2 = new Exam();
        e2.setName("T02");
        e2.setDate(cal.getTime());
        e2.setScore(84.5);
        e2.setWeight(1.50);
        exams.add(e2);

        cal.add(Calendar.WEEK_OF_YEAR, 2);
        Exam e3 = new Exam();
        e3.setName("MID");
        e3.setDate(cal.getTime());
        e3.setScore(79.0);
        e3.setWeight(2.00);
        exams.add(e3);

        cal.add(Calendar.WEEK_OF_YEAR, 2);
        Exam e4 = new Exam();
        e4.setName("T03");
        e4.setDate(cal.getTime());
        e4.setScore(99.0);
        e4.setWeight(1.00);
        exams.add(e4);

        cal.add(Calendar.WEEK_OF_YEAR, 2);
        Exam e5 = new Exam();
        e5.setName("T04");
        e5.setDate(cal.getTime());
        e5.setScore(65.0);
        e5.setWeight(1.75);
        exams.add(e5);

        cal.add(Calendar.WEEK_OF_YEAR, 2);
        Exam e6 = new Exam();
        e6.setName("FIN");
        e6.setDate(cal.getTime());
        e6.setScore(83.0);
        e6.setWeight(4.00);
        exams.add(e6);

        enroll.setExams(exams);
        return enroll;

    }

}
