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

import org.apache.log4j.Logger;

import com.discursive.jccook.util.LogInit;

public class BuilderBeanExample {

    private static Logger logger = Logger.getLogger(BuilderBeanExample.class);
    static {
        LogInit.init();
    }

    private BuilderBean builder, builder2, builder3;

    public static void main(String[] pArgs) throws Exception {
        BuilderBeanExample example = new BuilderBeanExample();
        example.initialize();
        example.testToString();
        example.testHashCode();
        example.testEquals();
        example.testCompare();
    }

    protected void initialize() throws Exception {
        // Builder and Builder2 contain the same content
        builder = new BuilderBean();
        builder.setProp1("One");
        builder.setProp2("Two");

        builder2 = new BuilderBean();
        builder2.setProp1("One");
        builder2.setProp2("Two");

        builder3 = new BuilderBean();
        builder3.setProp1("Uno");
        builder3.setProp2("Dos");
    }

    public void testToString() throws Exception {
        logger.info("ToStringBuilder: " + builder.toString());
    }

    public void testHashCode() throws Exception {
        logger.info("HashCodeBuilder: " + builder.hashCode());
    }

    public void testEquals() throws Exception {
        logger.info("builder equals builder2: " + builder.equals(builder2));
        logger.info("builder equals builder3: " + builder.equals(builder3));
    }

    public void testCompare() throws Exception {
        logger.info(
            "builder compareTo builder2: " + builder.compareTo(builder2));
        logger.info(
            "builder compareTo builder3: " + builder.compareTo(builder3));
    }

}
