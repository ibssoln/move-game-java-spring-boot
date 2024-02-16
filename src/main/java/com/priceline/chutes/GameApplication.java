package com.priceline.chutes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameApplication{ //NOTE: This is another addition to make the entire app as a Spring-Boot supported to increase maintainability & extensibility.

	//NOTE: added a SLF4J logger to log info and errors via the logging facility.
	private static final Logger LOG = LoggerFactory.getLogger(GameApplication.class);

	//************************************************
	//NOTE: You can run a game in 2 different ways.
	// 1. By sending a request to the RESTful service endpoint after the Spring Boot server is up and running.
	// 2. By running a gradle build (gradle run --args="CHUTES_AND_LADDER Jane Mike Doug Chloe") in the command line, where the args are the names of the players.
	//************************************************

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
	}

}
