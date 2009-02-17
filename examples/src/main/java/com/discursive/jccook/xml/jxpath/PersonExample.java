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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.discursive.jccook.util.LogInit;
import com.discursive.jccook.xml.bean.BetwixtExample;

public class PersonExample {

    private static Logger logger = Logger.getLogger(BetwixtExample.class);
    static { LogInit.init(); }

    public static void main(String[] args) throws IOException, SAXException {
        new PersonExample().start();
    }
    
    public void start() throws IOException, SAXException {
    	
    	List people = new ArrayList();
    	
    	Person person1 = new Person();
    	person1.setFirstName( "Ahmad" );
    	person1.setLastName( "Russell" );
    	person1.setAge( 28 );
    	people.add( person1 );
    	
    	Person person2 = new Person();
    	person2.setFirstName( "Tom" );
    	person2.setLastName( "Russell" );
    	person2.setAge( 35 );
    	people.add( person2 );

    	Person person3 = new Person();
    	person3.setFirstName( "Ahmad" );
    	person3.setLastName( "Abuzayedeh" );
    	person3.setAge( 33 );
    	people.add( person3 );

	   	System.out.println( "** People older than 30");
	    JXPathContext context = JXPathContext.newContext( people );
	    Iterator iterator = context.iterate(".[@age > 30]");
	    printPeople(iterator);
	
	    context = JXPathContext.newContext( people );
	    System.out.println( "** People with first name 'Ahmad'" );
	    iterator = context.iterate(".[@firstName = 'Ahmad']");
	    printPeople(iterator);

		context = JXPathContext.newContext( people );
		System.out.println( "** Second Person in List" );
		Person p = (Person) context.getValue(".[2]");
		System.out.println( "Person: " + p.getFirstName() + " " + p.getLastName() +
							", age: " + p.getAge() );
}
	
		private void printPeople(Iterator iterator) {
			while( iterator.hasNext() ) {
	            Person p = (Person) iterator.next();
	            System.out.println( "Person: " + p.getFirstName() + " " + p.getLastName() +
	            					", age: " + p.getAge() );
	        }
		}
	}
