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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.FromXmlRuleSet;
import org.xml.sax.SAXException;

public class XMLNamespaceDigest {
	public static void main(String[] args) throws IOException, SAXException {
		new XMLNamespaceDigest().testDigest();
	}

	public void testDigest() throws IOException, SAXException {

		Pages pages = new Pages();
		
		Digester digester = new Digester();
		digester.setNamespaceAware(true);

		digester.setRuleNamespaceURI("http://discursive.com/page");
		URL pageRules = getClass().getResource("./page-rules.xml");
		digester.addRuleSet( new FromXmlRuleSet( pageRules ) );
		
		digester.setRuleNamespaceURI("http://discursive.com/person");
		URL personRules = getClass().getResource("./person-rules.xml");
		digester.addRuleSet( new FromXmlRuleSet( personRules ) );
		
		digester.push(pages);

		InputStream input = getClass().getResourceAsStream("./content.xml");
		digester.parse(input);

		Page page = (Page) pages.getPages().get(0);
		System.out.println(page);
	}
}

