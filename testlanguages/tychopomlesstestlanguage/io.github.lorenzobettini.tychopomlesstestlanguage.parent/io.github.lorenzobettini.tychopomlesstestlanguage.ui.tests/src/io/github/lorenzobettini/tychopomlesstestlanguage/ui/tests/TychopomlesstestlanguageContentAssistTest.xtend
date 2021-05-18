package io.github.lorenzobettini.tychopomlesstestlanguage.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(TychopomlesstestlanguageUiInjectorProvider)
class TychopomlesstestlanguageContentAssistTest extends AbstractContentAssistTest {

	@Test def void testCompletion() {
		newBuilder.assertText('Hello')
	}

}
