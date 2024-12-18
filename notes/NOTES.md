In `build.properties`:

```
additional.bundles = org.eclipse.xtext.xtext.generator.dependencies
```

In `.target`:

```xml
<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
<unit id="de.itemis.xtext.antlr.feature.feature.group" version="2.1.1.v201405091103"/>
<repository location="https://download.itemis.com/updates/releases/2.1.1/"/>
</location>
```
