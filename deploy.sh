#!/bin/sh

mvn -f releng/io.github.lorenzobettini.xtextutils.releng/pom.xml \
	-Psonatype-oss-release \
	clean package deploy

