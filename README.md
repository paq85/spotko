# Spotko 

Organize successful meetings.

## Setup & Run

[![Build Status](https://travis-ci.org/paq85/spotko.svg?branch=master)](https://travis-ci.org/paq85/spotko)

	./mvnw clean package
	java -jar target/spotko-0.0.1-SNAPSHOT.jar
	
Application is available at [localhost:8080](http://localhost:8080)

## Deploy

	heroku ps:scale web=1 --app spotko