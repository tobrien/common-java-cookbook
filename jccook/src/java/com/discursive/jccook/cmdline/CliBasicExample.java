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
import org.apache.commons.cli.Options;

public class CliBasicExample {

    public static void main(String[] args) throws Exception {
        CommandLineParser parser = new BasicParser();

        Options options = new Options();
        options.addOption("h", "help", false, "Print this usage information");
        options.addOption("v", "verbose", false, "Print out VERBOSE debugging information" );
        options.addOption("f", "file", true, "File to save program output to");

        CommandLine commandLine = parser.parse( options, args );

        boolean verbose = false;
        String file = "";

        if( commandLine.hasOption('h') ) {
            System.out.println( "Help Message");
            System.exit(0);
        }

        if( commandLine.hasOption('v') ) {
            verbose = true;
        }

        if( commandLine.hasOption('f') ) {
            file = commandLine.getOptionValue('f');
        }

        System.exit(0);
    }

}
