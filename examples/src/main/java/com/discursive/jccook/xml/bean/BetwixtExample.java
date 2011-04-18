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
package com.discursive.jccook.xml.bean;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.betwixt.io.BeanWriter;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.log4j.Logger;

import com.discursive.jccook.util.LogInit;
import org.apache.commons.betwixt.io.AbstractBeanWriter;

/**
 * Include a table of the Values in DateFormatUtils
 */
public class BetwixtExample {

    private static Logger logger = Logger.getLogger(BetwixtExample.class);
    static { LogInit.init(); }

    public static void main(String[] pArgs) throws Exception {
        BetwixtExample example = new BetwixtExample();
        example.testXmlOutput();
        example.testCustomXmlOutput();
    }

    public void testXmlOutput() throws Exception {

        List plays = new ArrayList();

        InputStream input = getClass().getResourceAsStream("./plays.xml");
        URL rules = getClass().getResource("./play-rules.xml");
        Digester digester = DigesterLoader.createDigester(rules);
        digester.push(plays);
        Object root = digester.parse(input);

        logger.debug("Number of plays: " + plays.size());

        Play play = (Play) plays.get(0);

        BeanWriter beanWriter = new BeanWriter();
        beanWriter.enablePrettyPrint();
        beanWriter.write(play);

        logger.debug(beanWriter.toString());
    }

    public void testCustomXmlOutput() throws Exception {

        List plays = new ArrayList();

        InputStream input = getClass().getResourceAsStream("./plays.xml");
        URL rules = getClass().getResource("./play-rules.xml");
        Digester digester = DigesterLoader.createDigester(rules);
        digester.push(plays);
        Object root = digester.parse(input);

        logger.debug("Number of plays: " + plays.size());

        Play play = (Play) plays.get(0);

        BeanWriter beanWriter = new BeanWriter();
        beanWriter.enablePrettyPrint();
        beanWriter.write(play);

        logger.debug(beanWriter.toString());
    }

}
