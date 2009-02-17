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

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.xml.sax.SAXException;

import com.discursive.jccook.util.LogInit;

public class PlayIndexer {

    private static Logger logger = Logger.getLogger( PlayIndexer.class );
    static { LogInit.init(); }

    private IndexWriter indexWriter;
    private Digester digester;
    private DigestContext context;
    
    public PlayIndexer(IndexWriter pIndexWriter) {
        indexWriter = pIndexWriter;
    }
    
    public void init() {
        URL playRules = PlayIndexer.class.getResource("play-digester-rules.xml");
        digester = DigesterLoader.createDigester( playRules );
        digester.setValidating(false);
    }
        
    public void index(File playXml) throws IOException, SAXException {
        context = new DigestContext();
        digester.push( context );
        digester.parse( playXml );
        logger.info( "Parsed: " + playXml.getAbsolutePath() );
    }
    
    public void processSpeech() {
        Document doc = new Document();
        doc.add(Field.Text("play", context.playTitle));
        doc.add(Field.Text("act", context.actTitle));
        doc.add(Field.Text("scene", context.sceneTitle));
        doc.add(Field.Text("speaker", context.speaker));
        doc.add(Field.Text("speech", context.speech.toString()));
        try {
            indexWriter.addDocument( doc );
        } catch( IOException ioe ) {
            logger.error( "Unable to add document to index", ioe);
        }
    }
    
    public class DigestContext {
        File playXmlFile;
        String playTitle, actTitle, sceneTitle, speaker;
        StringBuffer speech = new StringBuffer();

        public void setActTitle(String string) { actTitle = string; }
        public void setPlayTitle(String string) { playTitle = string; }
        public void setSceneTitle(String string) { sceneTitle = string; }
        public void setSpeaker(String string) { speaker = string; }
        public void appendLine(String pLine) { speech.append( pLine ); }

        public void speechEnd() {
            processSpeech();
            speech.delete( 0, speech.length() );
            speaker = "";
        }
    }
}
