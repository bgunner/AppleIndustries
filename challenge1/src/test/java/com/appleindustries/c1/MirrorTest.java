package com.appleindustries.c1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MirrorTest {

	@Test
	public void testReverseIt_otto() {
		String expected = "otto";
		assertEquals(expected, Mirror.reverseIt("otto"));
	}

	@Test
	public void testReverseIt_apple() {
		String expected = "elppa";
		assertEquals(expected, Mirror.reverseIt("apple"));
	}
	
	@Test
	public void testReverseIt_industries() {
		String expected = "seirtsudni";
		assertEquals(expected, Mirror.reverseIt("industries"));
	}
	
}
