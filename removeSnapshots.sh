#!/bin/sh

mvn -f releng/io.github.lorenzobettini.xtextutils.releng/pom.xml \
	versions:set \
	-DgenerateBackupPoms=false \
	-DremoveSnapshot=true

