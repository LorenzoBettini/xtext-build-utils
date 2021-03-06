/*
 * generated by Xtext 2.20.0
 */
package io.github.lorenzobettini.tychotestlanguage.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.github.lorenzobettini.tychotestlanguage.TychotestlanguageRuntimeModule;
import io.github.lorenzobettini.tychotestlanguage.TychotestlanguageStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class TychotestlanguageIdeSetup extends TychotestlanguageStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new TychotestlanguageRuntimeModule(), new TychotestlanguageIdeModule()));
	}
	
}
