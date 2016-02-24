#!/bin/sh

MAJOR_VERSION="4.2"
FULL_VERSION="4.2.0"

curl -sS -O https://raw.githubusercontent.com/ExLibrisGroup/Rosetta.dps-sdk-projects/master/$MAJOR_VERSION/dps-sdk-deposit/lib/dps-sdk-$FULL_VERSION.jar
mvn install:install-file -Dfile=dps-sdk-$FULL_VERSION.jar -DgroupId=com.exlibris.dps \
    -DartifactId=dps-sdk -Dversion=$FULL_VERSION -Dpackaging=jar
