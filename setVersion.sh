#!/bin/sh

if [ $# -eq 0 ]; then
    echo "No arguments provided: pass the version number"
    exit 1
fi

# versions:set will also scan the test projects and update them accordingly
mvn -f releng/io.github.lorenzobettini.xtextutils.releng/pom.xml \
	versions:set \
	-DgenerateBackupPoms=false \
	-DnewVersion=$1

