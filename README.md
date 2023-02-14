# SQL RX

A working Java project that uses Spring Boot and R2DBC to return data reactively from a MySQL 8 database. Configurable with application properties and with build-time tests.

Read more about this project at [Medium.com](https://robinedwardellis.medium.com/reactive-mysql-with-spring-boot-1b184b9ea58a)

## Test data

There is a SQL script in sql folder that will drop the schema if it exists and create it again. Remember to apply a user to the schema and update the username and password in application.properties

Test data is the agent list from the static data dump of EVE Online, May 2022. 

## Building

`mvn clean install`

## Endpoints

- `/agents` - get all agents
- `/agents/101` - get an agent by ID (range is 3008416 to 3019501)
- `/agents/ids` - get IDs for all agents (integer)
- `/agents/corp/id` - get agents for the given corporation ID (range is 1000002 to 1000182)
- `/agents/location/id` - get agents for the given location ID (range is 60000004 to 60015146)

### Examples

`curl -i http://localhost:8080/agents` - get all agents

`curl -i http://localhost:8080/agents/3019483` - get a single agent

`curl -i http://localhost:8080/agents/101` - agent not found


## CCP hf. Copyright Notice

EVE Online, the EVE logo, EVE and all associated logos and designs are the intellectual property of CCP hf. All artwork, screenshots, characters, vehicles, storylines, world facts or other recognizable features of the intellectual property relating to these trademarks are likewise the intellectual property of CCP hf. EVE Online and the EVE logo are the registered trademarks of CCP hf. All rights are reserved worldwide. All other trademarks are the property of their respective owners. CCP hf. has granted permission to Robin Ellis to use EVE Online and all associated logos and designs for promotional and information purposes but does not endorse, and is not in any way affiliated with, Robin Ellis or this project. CCP is in no way responsible for the content on or functioning of this project, nor can it be liable for any damage arising from the use of this project.
