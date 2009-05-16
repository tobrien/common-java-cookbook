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

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.ObjectCreateRule;
import org.apache.commons.digester.RuleSetBase;
import org.apache.commons.digester.Rules;
import org.apache.commons.digester.SetNextRule;
import org.xml.sax.SAXException;

public class NamespaceDigest {
	public static void main(String[] args) throws IOException, SAXException {
		new NamespaceDigest().testDigest();
	}

	public void testDigest() throws IOException, SAXException {

		Pages pages = new Pages();
		
		Digester digester = new Digester();
		digester.setNamespaceAware(true);
		digester.addRuleSet( new PageRuleSet() );
		digester.addRuleSet( new PersonRuleSet() );
		
		digester.push(pages);

		InputStream input = getClass().getResourceAsStream("./content.xml");
		digester.parse(input);

		Page page = (Page) pages.getPages().get(0);
		System.out.println(page);
	}

	private void addPageRules(Rules rules) {
		rules.add("*/page", new ObjectCreateRule(Page.class));
		rules.add("*/page", new SetNextRule("add"));
	}

	public class PersonRuleSet extends RuleSetBase {
		public PersonRuleSet() {
			this.namespaceURI = "http://discursive.com/person";
		}

		public void addRuleInstances(Digester digester) {
			digester.addObjectCreate("*/person", Person.class);
			digester.addSetNext("*/person", "addPerson");
			digester.addSetProperties("*/person");
			digester.addBeanPropertySetter("*/person/role", "role");
		}
	}

	public class PageRuleSet extends RuleSetBase {
		public PageRuleSet() {
			this.namespaceURI = "http://discursive.com/page";
		}

		public void addRuleInstances(Digester digester) {
			digester.addObjectCreate("*/page", Page.class);
			digester.addSetNext("*/page", "addPage");
			digester.addSetProperties("*/page");
			digester.addBeanPropertySetter("*/page/summary", "summary");
		}
	}

}

