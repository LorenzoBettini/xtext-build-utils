package io.github.lorenzobettini.tychotestlanguage.maven.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class TychotestlanguageGeneratedOutputTest {

	@Test
	void testGeneratedOutput() throws UnsupportedEncodingException, IOException {
		String contents = new String(
				Files.readAllBytes(Paths.get("src-gen/greetings.txt")),
				"UTF8");
		assertEquals("People to greet: Xtext, World", contents);
	}

}
