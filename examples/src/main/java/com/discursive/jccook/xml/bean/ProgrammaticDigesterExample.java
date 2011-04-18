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
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.digester.BeanPropertySetterRule;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.ObjectCreateRule;
import org.apache.commons.digester.Rules;
import org.apache.commons.digester.SetNextRule;
import org.apache.commons.digester.SetPropertiesRule;
import org.apache.log4j.Logger;

import com.discursive.jccook.util.LogInit;

public class ProgrammaticDigesterExample {

    private static Logger logger = Logger.getLogger(DigesterExample.class);
    static { LogInit.init(); }

    public static void main(String[] pArgs) throws Exception {
        ProgrammaticDigesterExample example = new ProgrammaticDigesterExample();
        example.testDigest();
    }

    public void testDigest() throws Exception {

        List plays = new ArrayList();

        Digester digester = new Digester();
        Rules rules = digester.getRules();
        rules.add( "plays/play", new ObjectCreateRule("com.discursive.jccook.xml.bean.Play"));
        rules.add( "plays/play", new SetNextRule("add", "java.lang.Object") );
        rules.add( "plays/play", new SetPropertiesRule() );
        rules.add( "plays/play/name", new BeanPropertySetterRule("name") );
        rules.add( "plays/play/summary", new BeanPropertySetterRule("summary") );
        rules.add( "plays/play/author", new BeanPropertySetterRule("author") );
        rules.add( "plays/play/characters/character", new ObjectCreateRule("com.discursive.jccook.xml.bean.Character"));
        rules.add( "plays/play/characters/character", new SetNextRule("addCharacter", "com.discursive.jccook.xml.bean.Character"));
        rules.add( "plays/play/characters/character", new SetPropertiesRule() );
        rules.add( "plays/play/characters/character/name", new BeanPropertySetterRule("name") );
        rules.add( "plays/play/characters/character/description", new BeanPropertySetterRule("description") );
        digester.push(plays);

        InputStream input = getClass().getResourceAsStream("./plays.xml");
        digester.parse( input );
        
        System.out.println("Number of plays: " + plays.size());
    }
}
