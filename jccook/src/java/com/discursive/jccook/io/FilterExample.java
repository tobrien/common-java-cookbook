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
package com.discursive.jccook.io;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.OrFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.lang.ArrayUtils;


public class FilterExample {
	public static void main(String[] args) {
		new FilterExample().start();
	}
	
	public void start() {
		File rootDir = new File(".");
		FilenameFilter fileFilter = new SuffixFileFilter(".xml");
		String[] xmlFiles = rootDir.list( fileFilter );
		System.out.println( "*** XML Files" );
		System.out.println( ArrayUtils.toString( xmlFiles ) );		


		rootDir = new File("./test");

		IOFileFilter htmlFilter = new OrFileFilter( new SuffixFileFilter("htm"),
											   new SuffixFileFilter("html") );
		IOFileFilter notDirectory = new NotFileFilter( DirectoryFileFilter.INSTANCE );
		fileFilter = new AndFileFilter( htmlFilter, notDirectory );

		String[] htmlFiles = rootDir.list(fileFilter);
		System.out.println( "*** HTML Files" );
		System.out.println( ArrayUtils.toString( htmlFiles ) );
	}

}
