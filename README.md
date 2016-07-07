# Spotko 

Organize successful meetings.

## Setup

[![Build Status](https://travis-ci.org/paq85/spotko.svg?branch=master)](https://travis-ci.org/paq85/spotko)

### Database - PostgreSQL

[Install PostgreSQL and configure it](https://help.ubuntu.com/community/PostgreSQL) to let `spotko_user` with password `spotko` access `localhost` database called `spotko_dev`.

Eg. on Ubuntu:
	
	sudo apt-get install postgresql-client postgresql
	sudo -u postgres createdb spotko_dev
	sudo -u postgres createuser spotko_user
	sudo -u postgres psql
	postgres=# \password spotko_user
	Enter new password: spotko
	
If you want to use different PostgreSQL user or database simply override `application.properties` settings with `spring.datasource.` prefix.

### Facebook authentication
Please adjust application.properties or inject proper values using one of supported [methods](http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html#boot-features-external-config-profile-specific-properties)

Properties that need to be set up: `facebook.client.client-id` and `facebook.client.client-secret`

Eg. you can use this trick

	java -Dspring.application.json='{"facebook.client.client-id":"123", "facebook.client.client-secret": "123"}' -jar myapp.jar
	
Or set environment variables

	FACEBOOK_CLIENT_CLIENT-ID=123
	FACEBOOK_CLIENT_CLIENT-SECRET=123
	
## Run

	./mvnw clean package
	java -jar target/spotko-0.0.1-SNAPSHOT.jar
	
Application is available at [localhost:8080](http://localhost:8080)

## Deploy

	heroku ps:scale web=1 --app spotko