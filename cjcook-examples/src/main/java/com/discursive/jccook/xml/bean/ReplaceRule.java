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

import org.apache.commons.digester.Rule;
import org.apache.commons.lang.StringUtils;
import org.xml.sax.Attributes;

public class ReplaceRule extends Rule {
	public ReplaceRule() { super(); }

	public void begin(Attributes attributes) throws Exception {
		Message message = (Message) digester.getRoot();
		
		String repl = attributes.getValue("search");
		String with = attributes.getValue("replace");
		String text = message.getText();
		
		String translated = 
			StringUtils.replace( text, repl, with );
		message.setText( translated );
	}
}