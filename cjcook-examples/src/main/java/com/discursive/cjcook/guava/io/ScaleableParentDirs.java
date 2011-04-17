package com.discursive.cjcook.guava.io;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.io.Files;

public class ScaleableParentDirs {
	
	private static final Integer PATH_LENGTH = 5;
	private static final Integer NAME_LENGTH = 2;

	public static void main(String[] args) throws Exception {

		StringBuffer randomPath = new StringBuffer();
		for( int i = 0; i < 5; i++) {
			randomPath.append( RandomStringUtils.randomAlphabetic(1).toLowerCase() );
			randomPath.append( File.separator );
		}
		String randomName = RandomStringUtils.randomAlphabetic(2).toLowerCase();
		File newFile = new File( randomPath.toString(), randomName + ".dat" );
		Files.createParentDirs( newFile );
		
		// Do whatever
	}

}
