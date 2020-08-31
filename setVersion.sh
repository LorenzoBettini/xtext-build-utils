#!/bin/sh

if [ $# -eq 0 ]; then
    echo "No arguments provided: pass the version number"
    exit 1
fi

# It is crucial to use -N because in test projects parents have no relative path
# and are not resolvable
mvn -N -f releng/io.github.lorenzobettini.xtextutils.releng/pom.xml \
	-Pupdate-versions \
	versions:set \
	-DgenerateBackupPoms=false \
	-DnewVersion=$1

