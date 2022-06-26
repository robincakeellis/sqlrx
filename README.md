# SQL RX

A working Java project that uses Spring Boot and R2DBC to return data reactively from a MySQL 8 database. Configurable with application properties and with build-time tests.

## Test data

There is a SQL script in sql folder that will create the schema. Remember to apply a user to it and update the username and password in application.properties

Test data is the agent files from the static data dump of EVE Online, May 2022. 

## Building

`mvn clean install`

## CCP hf. Copyright Notice

EVE Online, the EVE logo, EVE and all associated logos and designs are the intellectual property of CCP hf. All artwork, screenshots, characters, vehicles, storylines, world facts or other recognizable features of the intellectual property relating to these trademarks are likewise the intellectual property of CCP hf. EVE Online and the EVE logo are the registered trademarks of CCP hf. All rights are reserved worldwide. All other trademarks are the property of their respective owners. CCP hf. has granted permission to Robin Ellis to use EVE Online and all associated logos and designs for promotional and information purposes but does not endorse, and is not in any way affiliated with, Robin Ellis or this project. CCP is in no way responsible for the content on or functioning of this project, nor can it be liable for any damage arising from the use of this project.
