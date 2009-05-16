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
package com.discursive.jccook.xml.jxpath;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.discursive.jccook.util.LogInit;
import com.discursive.jccook.xml.bean.BetwixtExample;

public class PlanetSearch {

    private static Logger logger = Logger.getLogger(BetwixtExample.class);
    static { LogInit.init(); }

    public static void main(String[] args) throws IOException, SAXException {
        new PlanetSearch().planetSearch();
    }
    
    public void planetSearch() throws IOException, SAXException {
        List planets = new ArrayList();

        InputStream input = getClass().getResourceAsStream("./planets.xml");
        URL rules = getClass().getResource("./planet-digester-rules.xml");
        Digester digester = DigesterLoader.createDigester(rules);
        digester.push(planets);
        digester.parse( input );

        System.out.println("Number of planets: " + planets.size());
        
        System.out.println( "Planet Name where radius > 5000");
        JXPathContext context = JXPathContext.newContext( planets );
        Iterator iterator = context.iterate(".[@radius > 5000]/name");
        while( iterator.hasNext() ) {
            Object o  = (Object) iterator.next();
            System.out.println( "Object: " + o);
        }

        System.out.println( "Planet Name where a moon is named Deimos");
        iterator = context.iterate("./moons[. = 'Deimos']/../name");
        while( iterator.hasNext() ) {
            String name  = (String) iterator.next();
            System.out.println( "Planet Namet: " + name);
        }
        
        System.out.println( "Planet where Helium percentage greater than 2");
        iterator = context.iterate("./atmosphere/components/He[.>2]/../../..");
        while( iterator.hasNext() ) {
            Planet p  = (Planet) iterator.next();
            System.out.println( "Planet: " + p.getName());
        }

        System.out.println( "All of the Moon Names");
        iterator = context.iterate("./moons");
        while( iterator.hasNext() ) {
            String moon  = (String) iterator.next();
            context.getVariables().declareVariable("moonName", moon);
            String planet = (String) context.getValue("./moons[. = $moonName]/../name");
            System.out.println( "Moon: " + moon + ", \t\t\tPlanet: " + planet);
        }
    }
}
