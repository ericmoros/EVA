package com.hotmail.steven.bconomy.util;

public class NumberUtil {

	public static String removeNoneDigits(String string) {
		
		return string.replaceAll("\\D+","");
		
	}
	
}
