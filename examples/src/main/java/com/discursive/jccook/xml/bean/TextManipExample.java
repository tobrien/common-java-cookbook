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

import org.apache.commons.digester.Digester;
import org.apache.log4j.Logger;

import com.discursive.jccook.util.LogInit;

public class TextManipExample {

    private static Logger logger = Logger.getLogger(TextManipExample.class);
    static { LogInit.init(); }

    public static void main(String[] pArgs) throws Exception {
        TextManipExample example = new TextManipExample();
        example.testDigest();
    }

    public void testDigest() throws Exception {

    	Message message = new Message();
    	message.setText( "hello world!" );
    	
        System.out.println( "Initial Message: " + message.getText() );
        
        
        InputStream encrypt = getClass().getResourceAsStream("./encrypt.xml");
        InputStream decrypt = getClass().getResourceAsStream("./decrypt.xml");

        Digester digester = new Digester();
        digester.addRule( "*/email", new EmailRule() );
        digester.addRule( "*/lower", new LowerRule() );
        digester.addRule( "*/reverse", new ReverseRule() );
        digester.addRule( "*/replace", new ReplaceRule() );
        digester.push( message );
        
        digester.parse( encrypt );
//        digester.parse( decrypt );

        System.out.println("Resulting Message: " + message.getText() );

        digester.parse( decrypt );
        
        System.out.println("Resulting Message: " + message.getText() );

}
}
