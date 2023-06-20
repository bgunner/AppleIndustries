package com.appleindustries.c1;

public class Mirror {

	public static String reverseIt(String seed) {
		char[] sequence = seed.toCharArray();
		int size = sequence.length;
		int midSize = size / 2;
				
		for (int i = 0; i < midSize; i++) {
			char thisChar = sequence[i];
			sequence[i] = sequence[size - 1 - i];
			sequence[size- 1 - i] = thisChar;
		}
		return new String(sequence);
	}
}
