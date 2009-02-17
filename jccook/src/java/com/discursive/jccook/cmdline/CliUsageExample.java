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
package com.discursive.jccook.cmdline;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class CliUsageExample {

    CommandLineParser parser;
    Options options;
    CommandLine commandLine;
    
    private static final String USAGE = "java com.discursive.jccook.cmdline.CliExample";
    private static final String HEADER = "Jakarta Commons Cookbook CliExample version 1.0";
    private static final String FOOTER = "Form more information plase see: http://www.supergreg.com";
    
    public CliUsageExample() {
        parser = new PosixParser();
        options = new Options();
        initializeOptions();
    }

    private void initializeOptions() {
        options.addOption("h", "help", false, "Print this usage information");
        options.addOption("z", "compress", false, "Compress program output");
        options.addOption("v", "verbose", false, "Print out VERBOSE debugging information" );
        options.addOption("f", "file", true, "File to save program output to");
    }

    public static void main(String[] args) {

        CliUsageExample cliExample = new CliUsageExample();
        cliExample.run( args );

        System.exit(0);
    }

    private void run(String[] args) {
        try {
            commandLine = parser.parse( options, args );
        } catch( ParseException pe ) {
            printUsage();
        }
        
        if( commandLine.hasOption('h') ) { 
            printUsage(); 
            return;
        } else {
            printSuppliedOptions();
        }
    }
    
    private void printUsage() {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.setWidth( 80 );
        helpFormatter.printHelp( USAGE, HEADER, options, FOOTER, true);
    }
    
    private void printSuppliedOptions() {
        System.out.println( "Command Line Successfully Parsed!");
        if( commandLine.hasOption('v') ) { System.out.println( "\tRunning in Verbose Mode."); }        
        if( commandLine.hasOption('z') ) { System.out.println( "\tCompressing Program Output."); }        
        if( commandLine.hasOption('f') ) { System.out.println( "\tSending Output to File: " + commandLine.getOptionValue('f')); }        
    }
}
