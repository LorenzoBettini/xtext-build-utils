/*
 * generated by Xtext 2.25.0
 */
package io.github.lorenzobettini.maventestlanguage


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class MaventestlanguageStandaloneSetup extends MaventestlanguageStandaloneSetupGenerated {

	def static void doSetup() {
		new MaventestlanguageStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
