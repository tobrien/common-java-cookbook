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


public class LowerRule extends Rule {
	public LowerRule() { super(); }

	public void body(String namespace, String name, String text)
			throws Exception {
		Message message = (Message) digester.getRoot();
		String lower = StringUtils.lowerCase( message.getText() );
		message.setText( lower );
	}
}