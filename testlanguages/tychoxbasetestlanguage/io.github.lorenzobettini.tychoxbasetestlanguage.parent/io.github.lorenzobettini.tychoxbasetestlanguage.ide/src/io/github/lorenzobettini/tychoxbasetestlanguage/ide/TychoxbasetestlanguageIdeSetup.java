/*
 * generated by Xtext 2.20.0
 */
package io.github.lorenzobettini.tychoxbasetestlanguage.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.github.lorenzobettini.tychoxbasetestlanguage.TychoxbasetestlanguageRuntimeModule;
import io.github.lorenzobettini.tychoxbasetestlanguage.TychoxbasetestlanguageStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class TychoxbasetestlanguageIdeSetup extends TychoxbasetestlanguageStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new TychoxbasetestlanguageRuntimeModule(), new TychoxbasetestlanguageIdeModule()));
	}
	
}