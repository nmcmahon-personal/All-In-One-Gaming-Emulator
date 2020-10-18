# All-In-One Gaming Emulator

## Overview

This is a project still very much in it's early stages, so far no version of this has been released or is in any way functional or testable.

I plan to build an all-in-one gaming emulator that is designed to be ran on a small system such as a Raspberry Pi. It will be allow the user to select a gaming system between the following options (TBC) and emulate these systems seamlessly and easily.

Game consoles:
* Playstation One
* Nintendo 64
* Original Gameboy/GBC
* Nintendo Gamecube
* Nintendo 3DS

## How to build
This is a Java project built using Maven. To build, install [Apache Maven](http://maven.apache.org/download.cgi) and ensure you have the [Java 11 JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) installed on your machine.

When everything is installed, from the project root  directory, run the below command to build:

`mvn clean install`

To speed up the build, you can skip tests using the `skipTests` Maven property. The command would then become:

`mvn clean install -DskipTests`

## How to Run

If the build is successful, the project can be ran using the .jar file that is outputted in the `target` directory.

From the target directory, run the following command:

`java -jar all-in-one-gaming-emulator-1.0-SNAPSHOT-jar-with-dependencies.jar`

_**NOTE: 1.0-Snapshot is an example version and is subject to change. If the name of the jar file in the target folder is different, update the command to suit. Also ensure the jar selected ends with "-jar-with-dependencies"**_


