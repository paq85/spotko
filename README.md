# Spotko 

Organize successful meetings.

## Setup

[![Build Status](https://travis-ci.org/paq85/spotko.svg?branch=master)](https://travis-ci.org/paq85/spotko)

### Facebook authentication
Please adjust application.properties or inject proper values using one of supported methods http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html#boot-features-external-config-profile-specific-properties

Properties that need to be set up: `facebook.client.client-id` and `facebook.client.client-secret`

Eg. you can use this trick

	java -Dspring.application.json='{"facebook.client.client-id":"123", "facebook.client.client-secret": "123"}' -jar myapp.jar
	
## Run

	./mvnw clean package
	java -jar target/spotko-0.0.1-SNAPSHOT.jar
	
Application is available at [localhost:8080](http://localhost:8080)

## Deploy

	heroku ps:scale web=1 --app spotko