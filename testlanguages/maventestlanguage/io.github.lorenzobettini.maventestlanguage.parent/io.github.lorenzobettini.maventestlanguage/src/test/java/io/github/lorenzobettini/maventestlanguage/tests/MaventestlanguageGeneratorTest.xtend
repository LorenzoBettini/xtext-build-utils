package io.github.lorenzobettini.maventestlanguage.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(MaventestlanguageInjectorProvider)
class MaventestlanguageGeneratorTest {
	@Inject extension CompilationTestHelper

	@Test
	def void compileModel() {
		'''
			Hello Xtext!
			Hello World!
		'''.compile [
			Assertions.assertEquals(
				"People to greet: Xtext, World",
				getSingleGeneratedCode
			)
		]
	}
}
