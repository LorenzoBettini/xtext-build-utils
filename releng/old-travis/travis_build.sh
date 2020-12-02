#!/bin/bash

set -ev

# install our POMs
mvn -f releng/io.github.lorenzobettini.xtextutils.releng/pom.xml clean install && \
# run testlanguages using our POMs
mvn -U -f testlanguages/tychotestlanguage/io.github.lorenzobettini.tychotestlanguage.parent/pom.xml clean verify $ADDITIONAL && \
# run it again without source code generation (MWE2 and Xtend are skipped)
mvn -f testlanguages/tychotestlanguage/io.github.lorenzobettini.tychotestlanguage.parent/pom.xml clean verify -DskipMWE2 -DskipXtend $ADDITIONAL && \
# run the pure Maven test project
mvn -f testlanguages/maventestlanguage/io.github.lorenzobettini.maventestlanguage.parent/pom.xml clean verify && \
# run it again without source code generation (MWE2 and Xtend are skipped)
mvn -f testlanguages/maventestlanguage/io.github.lorenzobettini.maventestlanguage.parent/pom.xml clean verify -DskipMWE2 -DskipXtend && \
# run the Xbase Tycho test project
mvn -f testlanguages/tychoxbasetestlanguage/io.github.lorenzobettini.tychoxbasetestlanguage.parent/pom.xml clean verify $ADDITIONAL

