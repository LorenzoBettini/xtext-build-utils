/*
 * generated by Xtext 2.20.0
 */
package io.github.lorenzobettini.maventestlanguage;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class MaventestlanguageStandaloneSetup extends MaventestlanguageStandaloneSetupGenerated {

	public static void doSetup() {
		new MaventestlanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}