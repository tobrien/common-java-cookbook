#!/bin/sh
rm release.properties
mvn release:prepare --batch-mode 
mvn release:perform 
