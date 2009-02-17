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
package com.discursive.jccook.lang.date;

import java.util.Calendar;

import org.apache.commons.lang.time.DateUtils;

public class DateUtilsExamples {

    public static void main(String[] pArgs) throws Exception {

    	Calendar cal = Calendar.getInstance();
    	cal.set( 2004, 2, 5, 10, 2, 2 );
    	
    	System.out.println( DateUtils.round( cal.getTime() , DateUtils.SEMI_MONTH ) );
    	
    	
    }


}
