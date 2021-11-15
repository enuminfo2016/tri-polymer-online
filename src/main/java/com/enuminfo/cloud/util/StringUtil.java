package com.enuminfo.cloud.util;

import java.security.SecureRandom;
import java.util.Random;

public class StringUtil {
	private static final Random RANDOM = new SecureRandom();
	private static final int PASSWORD_LENGTH = 8;
	private static final StringUtil instance = new StringUtil();
	private StringUtil() {}
	public static StringUtil getInstance() {
		return instance;
	}
	
	public String generatePassword() {
		String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789@#";
		StringBuilder randomPassword = new StringBuilder();
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			int index = RANDOM.nextInt() * letters.length();
			randomPassword.append(letters.substring(index, index + 1));
		}
		return randomPassword.toString();
	}
	
	public String toTitleCase(String input) {
		if (input==null || "".equalsIgnoreCase(input)) return "";
		input = input.toLowerCase();
		StringBuilder titleCase = new StringBuilder();
	    boolean nextTitleCase = true;
	    for (char c : input.toCharArray()) {
	        if (Character.isSpaceChar(c)) {
	            nextTitleCase = true;
	        } else if (nextTitleCase) {
	            c = Character.toTitleCase(c);
	            nextTitleCase = false;
	        }
	        titleCase.append(c);
	    }
	    return titleCase.toString();
	}
}
