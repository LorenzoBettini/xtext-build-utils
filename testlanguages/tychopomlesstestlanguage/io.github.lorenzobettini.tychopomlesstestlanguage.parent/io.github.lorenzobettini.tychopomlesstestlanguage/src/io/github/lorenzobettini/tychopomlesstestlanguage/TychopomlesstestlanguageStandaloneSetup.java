/*
 * generated by Xtext 2.25.0
 */
package io.github.lorenzobettini.tychopomlesstestlanguage;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class TychopomlesstestlanguageStandaloneSetup extends TychopomlesstestlanguageStandaloneSetupGenerated {

	public static void doSetup() {
		new TychopomlesstestlanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
