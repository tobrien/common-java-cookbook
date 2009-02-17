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

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;

public class SomeApp {
    private static final String USAGE = "[-h] [-v] [-f <file> | -m <email>]";
    private static final String HEADER =
        "SomeApp - A fancy and expensive program, Copyright 2010 Blah.";
    private static final String FOOTER =
        "For more instructions, see our website at: http://www.blah123.org";

    public static void main(String[] args) throws Exception {
    	
	    // Create a Parser
        CommandLineParser parser = new BasicParser();
        Options options = new Options();
        options.addOption("h", "help", false, "Print this usage information");
        options.addOption("v", "verbose", false, "Print out VERBOSE information" );

        OptionGroup optionGroup = new OptionGroup(); 
        optionGroup.addOption( OptionBuilder.hasArg(true).withArgName("file")
        		                            .withLongOpt("file").create('f') );
        optionGroup.addOption( OptionBuilder.hasArg(true).withArgName("email")
        									.withLongOpt("email").create('m') );
        options.addOptionGroup( optionGroup );

   	    // Parse the program arguments
	    try {
            CommandLine commandLine = parser.parse( options, args );

            if( commandLine.hasOption('h') ) {
                printUsage( options );
                System.exit(0);
            }
	
   	        // ... do important stuff ...
        } catch( Exception e ) {
            System.out.println( "You provided bad program arguments!" );
            printUsage( options );
            System.exit(1);
        }
    }

    private static void printUsage(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.setWidth( 80 );
        helpFormatter.printHelp( USAGE, HEADER, options, FOOTER );
    }
}
