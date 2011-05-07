package org.kurikosu.util;

public class StringUtils {

	public static boolean isWithinUnicodeRange(String stringToTest, char begin, char end) {
		for (int i = 0; i < stringToTest.length(); i++) {
			char unicode = stringToTest.charAt(i);
			if (unicode < begin || unicode > end ) {
				return false;
			}
		}
		return true;
		
	}
	
}
