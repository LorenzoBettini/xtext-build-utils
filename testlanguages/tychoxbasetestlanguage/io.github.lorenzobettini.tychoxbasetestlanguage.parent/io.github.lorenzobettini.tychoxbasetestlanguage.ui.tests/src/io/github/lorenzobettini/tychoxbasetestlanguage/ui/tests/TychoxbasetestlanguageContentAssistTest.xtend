package io.github.lorenzobettini.tychoxbasetestlanguage.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(TychoxbasetestlanguageUiInjectorProvider)
class TychoxbasetestlanguageContentAssistTest extends AbstractContentAssistTest {
	@Test def void testImportCompletion() {
		newBuilder.append('Hello Xtext { val LinkedHashSet').assertText('java.util.LinkedHashSet')
	}
}