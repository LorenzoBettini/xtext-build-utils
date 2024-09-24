# Xtext Build Utils: Release notes

This page describes the noteworthy improvements each release provides and possible required manual changes to be applied.

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