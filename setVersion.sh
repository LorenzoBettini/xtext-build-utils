#!/bin/sh

if [ $# -eq 0 ]; then
    echo "No arguments provided: pass the version number"
    exit 1
fi

mvn -f xtext-maven-parent/io.github.lorenzobettini.xtextutils.xtext-maven-parent/pom.xml versions:set -DgenerateBackupPoms=false -DnewVersion=$1

mvn -f releng/io.github.lorenzobettini.xtextutils.releng/pom.xml versions:update-child-modules -DgenerateBackupPoms=false
