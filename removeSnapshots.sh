#!/bin/sh

mvn -f xtext-maven-parent/io.github.lorenzobettini.xtextutils.xtext-maven-parent/pom.xml versions:set -DgenerateBackupPoms=false -DremoveSnapshot=true

mvn -f releng/io.github.lorenzobettini.xtextutils.releng/pom.xml versions:update-child-modules -DgenerateBackupPoms=false
