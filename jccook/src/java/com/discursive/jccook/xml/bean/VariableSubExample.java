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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.Substitutor;
import org.apache.commons.digester.substitution.MultiVariableExpander;
import org.apache.commons.digester.substitution.VariableSubstitutor;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.log4j.Logger;

import com.discursive.jccook.util.LogInit;

public class VariableSubExample {

    private static Logger logger = Logger.getLogger(VariableSubExample.class);
    static { LogInit.init(); }

    public static void main(String[] pArgs) throws Exception {
        VariableSubExample example = new VariableSubExample();
        example.testDigest();
    }
   

    public void testDigest() throws Exception {

    	List emails = new ArrayList();

    	Map vars = new HashMap();
    	vars.put("email.to", "tobrien@discursive.com");
    	vars.put("user.name", "Tim");
    	vars.put("order.id", "1RR2E223WVVS" );
    	vars.put("product.name", "Foundation" );
    	
   	    MultiVariableExpander expander = new MultiVariableExpander();
    	expander.addSource("$", vars);

    	Substitutor substitutor = new VariableSubstitutor(expander);

        
        InputStream input = getClass().getResourceAsStream("./email.xml");

        URL rules = getClass().getResource("./email-rules.xml");
        Digester digester = DigesterLoader.createDigester(rules);
    	digester.setSubstitutor(substitutor);
        digester.push( emails );
        
        digester.parse( input );

        System.out.println("Resulting Email: " + emails.get(0) );

}
}
