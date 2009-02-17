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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.log4j.Logger;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.TermEnum;

import com.discursive.jccook.util.LogInit;

public class TermFreq {
    private static Logger logger = Logger.getLogger(TermFreq.class);
    static { LogInit.init(); }

    public static void main(String[] pArgs) throws Exception {
        logger.info("Threshold is 200" );
        Integer threshold = new Integer( 200 );

        IndexReader reader = IndexReader.open( "index" );
        TermEnum enumVar = reader.terms();
        List termList = new ArrayList();
        while( enumVar.next() ) {
            if( enumVar.docFreq() >= threshold.intValue() && 
                enumVar.term().field().equals( "speech" ) ) {
                Freq freq = new Freq( enumVar.term().text(), enumVar.docFreq() );
                termList.add( freq );
            }
        }
        Collections.sort( termList );
        Collections.reverse( termList );

        System.out.println( "Frequency | Term" );
        Iterator iterator = termList.iterator();
        while( iterator.hasNext() ) {
            Freq freq = (Freq) iterator.next();
            System.out.print( freq.frequency );
            System.out.println( " | " + freq.term );
        }
    }
    
    public static class Freq implements Comparable {
        String term;
        int frequency;
        
        public Freq( String term, int frequency ) {
            this.term = term;
            this.frequency = frequency;
        }
        
        public int compareTo(Object o) {
            if( o instanceof Freq ) {
                Freq oFreq = (Freq) o;
                return new CompareToBuilder()
                    .append( frequency, oFreq.frequency )
                    .append( term, oFreq.term )
                    .toComparison();
            } else {
                return 0;
            }
        }
    }
}