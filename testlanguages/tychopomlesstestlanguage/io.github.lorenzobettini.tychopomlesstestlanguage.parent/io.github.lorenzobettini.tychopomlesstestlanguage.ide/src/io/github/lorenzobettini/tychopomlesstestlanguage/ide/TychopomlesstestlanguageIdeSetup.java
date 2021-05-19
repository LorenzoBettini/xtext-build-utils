/*
 * generated by Xtext 2.25.0
 */
package io.github.lorenzobettini.tychopomlesstestlanguage.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.github.lorenzobettini.tychopomlesstestlanguage.TychopomlesstestlanguageRuntimeModule;
import io.github.lorenzobettini.tychopomlesstestlanguage.TychopomlesstestlanguageStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class TychopomlesstestlanguageIdeSetup extends TychopomlesstestlanguageStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new TychopomlesstestlanguageRuntimeModule(), new TychopomlesstestlanguageIdeModule()));
	}
	
}