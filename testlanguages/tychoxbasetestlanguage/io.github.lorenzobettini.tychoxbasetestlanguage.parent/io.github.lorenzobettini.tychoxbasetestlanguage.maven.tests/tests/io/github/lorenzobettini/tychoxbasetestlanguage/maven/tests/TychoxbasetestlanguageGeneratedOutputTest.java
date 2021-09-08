package io.github.lorenzobettini.tychoxbasetestlanguage.maven.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import example.MyWorld;

public class TychoxbasetestlanguageGeneratedOutputTest {

	@Test
	public void testGeneratedOutput() throws UnsupportedEncodingException, IOException {
		assertEquals("World", new MyWorld().toString());
	}

}
