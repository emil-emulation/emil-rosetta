# EMiL - Rosetta integration service
[![Build Status](https://travis-ci.org/emil-emulation/emil-rosetta.svg?branch=master)](https://travis-ci.org/emil-emulation/emil-rosetta) [![Codacy Badge](https://api.codacy.com/project/badge/grade/8d0a037738f541138b067d8cda7a269b)](https://www.codacy.com/app/marcus_2/emil-rosetta)

A microservice retrieving data from Rosetta, returning JSON or XML based on HTTP content negotiation (default: JSON).

## Introduction

**Start:**

    java -jar emil-rosetta.jar

Make sure that `application.yml` is the same directory as `emil-rosetta.jar`. The service is stateles and can safely be killed.

**Usage:**

    GET http://hostname/IE12345

    {
      "objectId": "IE12345",
      "files": [
        { "fileId": "FL12312.iso", "type": "ISO", "url": "http://rosetta-hostname/delivery/DeliveryManagerServlet?dps_pid=FL12312&dps_func=stream" },
        { "fileId": "FL12313.iso", "type": "ISO", "url": "http://rosetta-hostname/delivery/DeliveryManagerServlet?dps_pid=FL12313&dps_func=stream" },
        { "fileId": "FL12314.iso", "type": "ISO", "url": "http://rosetta-hostname/delivery/DeliveryManagerServlet?dps_pid=FL12314&dps_func=stream" }
      ]
    }

This service also offers a freely configurable demo object (see application.yml.template). The application.yml file has to be in the same directory as the jar file.

## Content Negotiation

If not ordered otherwise the service produces JSON. To get an XML representation, use `Accept: application/xml` header or add ".xml" at the end of the URL *(experimental)*.

## Development

### Installation of EMiL Integration Framework

Checkout and install EMiL Integration Framework to your local Maven repository:

    git clone https://github.com/emil-emulation/emil-integration-framework.git
    cd emil-integration-framework
    mvn clean install

### Installation of Rosetta PDS-SDK

To build this application, you need to install Rosetta DPS-SDK as Maven dependency as it is not available via public Maven repositories.

For any Unix-based System you can use the following script:

[/src/main/sh/install_rosetta_sdk_to_maven.sh](https://github.com/emil-emulation/emil-rosetta/blob/master/src/main/sh/install_rosetta_sdk_to_maven.sh)

To install manually, you can use (no curl? Just download the file):

    curl -sS -O https://raw.githubusercontent.com/ExLibrisGroup/Rosetta.dps-sdk-projects/master/4.2/dps-sdk-deposit/lib/dps-sdk-4.2.0.jar
    mvn install:install-file -Dfile=dps-sdk-4.2.0.jar -DgroupId=com.exlibris.dps -DartifactId=dps-sdk -Dversion=4.2.0 -Dpackaging=jar

Rosetta PDS-SDK is Copyright © 2015, Ex Libris Code Share. See the libraries [license](https://github.com/ExLibrisGroup/Rosetta.dps-sdk-projects/blob/master/LICENSE) for details.
