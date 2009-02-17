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
import java.util.List;

public class Book {
    private String name;
    private Author author;
    private List chapters = new ArrayList();

    public Book() {}
    public Book(String pName, Author pAuthor) {
        setName(pName);
        setAuthor(pAuthor);
    }
    
	public void addChapter( Chapter chapter ) { chapters.add( chapter ); }

    public String getName() { return name; }
    public void setName(String pName) { name = pName; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author pAuthor) { author = pAuthor; }

	public List getChapters() { return chapters; }
	public void setChapters(List list) { chapters = list; }
}
