package com.discursive.jccook.configuration;

import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.XMLConfiguration;

public class XmlConfigurationExample {

	public static void main(String[] args) throws Exception {
		String resource = "com/discursive/jccook/configuration/global.xml";
		Configuration config = new XMLConfiguration(resource);
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

		List startCriteria = config.getList("start-criteria.criteria");
		int horsepower = config.getInt("horsepower");
	}
}
