# Xtext Build Utils: Release notes

This page describes each release's noteworthy improvements and possible required manual changes to be applied.

## 0.21.0

* Tycho 4.0.13
* https://github.com/LorenzoBettini/xtext-build-utils/issues?q=is%3Aissue%20state%3Aclosed%20milestone%3A0.21.0

## 0.20.0

* Deploy to the new Central repository
* https://github.com/LorenzoBettini/xtext-build-utils/issues?q=is%3Aissue%20state%3Aclosed%20milestone%3A0.20.0

## 0.19.0

* Xtext 2.38.0, MWE2 2.21.0, Eclipse 2025-03
  * Remember to add
    ```xml
    <targetJRE path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-21"/>
    ```
    in the `.target` file.
* Tycho 4.0.12
* https://github.com/LorenzoBettini/xtext-build-utils/issues?q=is%3Aissue%20state%3Aclosed%20milestone%3A0.19.0

## 0.18.0

* Xtext 2.37.0, MWE2 2.20.0, Eclipse 2024-12
* Tycho 4.0.10

### Manual changes

* Use `org.eclipse.xtext.xtext.generator.dependencies` in the `build.properties` of the DSL project in `additional.bundles` removing all the listed dependencies the wizard used to generate.

## 0.17.0

* Xtext 2.36.0, MWE2 2.19.0, Eclipse 2024-09
* Tycho 4.0.9

### Manual changes

* Remove from MANIFESTs possible occurrences of old and removed bundles `org.eclipse.xtext.junit4` and `org.eclipse.xtext.xbase.junit`.
* In the DSL `build.properties`, change `org.apache.commons.logging` to `org.apache.commons.commons-logging`.
* In the `.target` file, in the 2024-09 location, add
```xml
<unit id="org.apache.commons.commons-logging" version="0.0.0"/>
```
.
