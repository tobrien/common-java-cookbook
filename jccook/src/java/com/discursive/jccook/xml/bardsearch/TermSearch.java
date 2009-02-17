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
package com.discursive.jccook.xml.bardsearch;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Searcher;

import com.discursive.jccook.util.LogInit;

public final class TermSearch {
    private TermSearch() {}

    private static Logger logger = Logger.getLogger(TermSearch.class);
    static { LogInit.init(); }

    public static void main(String[] pArgs) throws Exception {
        logger.info("Searching for " + pArgs[0]);
        Searcher searcher = new IndexSearcher("index");
        Analyzer analyzer = new SimpleAnalyzer();
        Query query = QueryParser.parse(pArgs[0], "speech", analyzer);
        Hits hits = searcher.search(query);
        logger.info( "Searching Done, hit: " + hits.length() );

        System.out.println( "Score | Play | Act | Scene | Speaker" );
        
        for( int i = 0; i < hits.length(); i++ ) {
            Document doc = hits.doc(i);
            System.out.print( (int) (hits.score(i) * 100 ) );
            System.out.print( " | " + doc.get("play") + " | " + doc.get("act") );
            System.out.print( " | " + doc.get("scene") );
            System.out.print( " | " + doc.get("speaker") + "\n" );
        }
    }
}