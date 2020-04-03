#!/bin/sh

mvn -f releng/io.github.lorenzobettini.xtextutils.releng/pom.xml clean package deploy -Psonatype-oss-release
