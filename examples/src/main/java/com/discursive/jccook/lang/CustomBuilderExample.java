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
package com.discursive.jccook.lang;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.discursive.jccook.util.LogInit;

public class CustomBuilderExample {

    private static Logger logger = Logger.getLogger(CustomBuilderExample.class);
    static {
        LogInit.init();
    }

    private TaxReturn return1, return2, return3;

    public static void main(String[] pArgs) throws Exception {
        CustomBuilderExample example = new CustomBuilderExample();
        example.initialize();
        example.testToString();
        example.testHashCode();
        example.testEquals();
        example.testCompare();
    }

    protected void initialize() throws Exception {
        return1 =
            new TaxReturn(
                "012-68-3242",
                1998,
                "O'Brien",
                new BigDecimal(43000.00));
        return2 =
            new TaxReturn(
                "012-68-3242",
                1999,
                "O'Brien",
                new BigDecimal(45000.00));
        return3 =
            new TaxReturn(
                "012-68-3242",
                1999,
                "O'Brien",
                new BigDecimal(53222.00));

    }

    public void testToString() throws Exception {
        logger.info("ToStringBuilder: " + return1.toString());
    }

    public void testHashCode() throws Exception {
        logger.info("HashCodeBuilder: " + return2.hashCode());
        Set set = new HashSet();
        set.add(return1);
        set.add(return2);
        set.add(return3);
    }

    public void testEquals() throws Exception {
        logger.info("return1 equals return2: " + return1.equals(return2));
        logger.info("return2 equals return3: " + return2.equals(return3));
    }

    public void testCompare() throws Exception {
        logger.info("return1 compareTo return2: " + return1.compareTo(return2));
        logger.info("return1 compareTo return3: " + return1.compareTo(return3));
    }

}
