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
package com.discursive.jccook.template.jexl;

import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionFactory;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlHelper;
import org.apache.log4j.Logger;

import com.discursive.jccook.util.LogInit;

/**
 * Include a table of the Values in DateFormatUtils
 */
public class JexlExample {

    private static Logger logger = Logger.getLogger(JexlExample.class);
    static {
        LogInit.init();
    }

    public static void main(String[] pArgs) throws Exception {
        JexlExample example = new JexlExample();
        example.testSimpleTemplate();
    }

    public void testSimpleTemplate() throws Exception {

        long[] numbers = {
            1, 3, 4, 6, 8, 9
        };
        String[] strings = {
            "Hello", "Goodbye"
        };
        Email email = new Email();

        //Expression e = ExpressionFactory.createExpression("strings[1].length() < 9");
        Expression e =
            ExpressionFactory.createExpression("email.test == 'TEST'");

        /*
         *  create a context and add data
         */
        JexlContext jc = JexlHelper.createContext();
        jc.getVars().put("numbers", numbers);
        jc.getVars().put("strings", strings);
        jc.getVars().put("email", email);

        Object o = e.evaluate(jc);
        logger.debug("result: " + o.getClass() + ", " + o);

    }

}