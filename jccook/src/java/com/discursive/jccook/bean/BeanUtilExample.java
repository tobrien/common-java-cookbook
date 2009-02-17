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
package com.discursive.jccook.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

public final class BeanUtilExample {

    private BeanUtilExample() {
    }

    private static String propName = "author.name";

    public static void main(String[] pArgs) {

        if (pArgs.length > 0 && pArgs[0] != null) {
            propName = pArgs[0];
        }
        System.out.println("Getting Property: " + propName);

        List books = createBooks();

		Iterator i = books.iterator();
        while( i.hasNext() ) {
			Book book = (Book) i.next();
            Object propVal = null;
            try {
                propVal = PropertyUtils.getProperty(book, propName);
            } catch (Exception e) {
                System.out.println(
                    "Error getting property: "
                        + propName
                        + ", from book: "
                        + book.getName()
                        + ", exception: "
                        + e.getMessage());
            }
            System.out.println("Property Value: " + propVal);
        }
    }

    private static List createBooks() {
        List retList = new ArrayList();
        retList.add(new Book("Java Threads", new Author("Oaks", "Pistachio")));
        retList.add(new Book("Hamlet", new Author("Willy", "Rocky Road")));
        return retList;
    }

}
