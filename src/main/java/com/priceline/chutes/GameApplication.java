package com.priceline.chutes;

import com.priceline.chutes.conventionalgame.ConventionalGameController;
import com.priceline.chutes.framework.Controller;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameApplication{ //NOTE: This is another addition to make the entire app as a Spring-Boot supported to increase maintainability & extensibility.

	//************************************************
	//NOTE: You can run a game in 2 different ways.
	// 1. By sending a request to the RESTful service endpoint after the Spring Boot server is up and running.
	// 2. By running a gradle build (gradle run --args="one two three four") in the command line, where the args are the names of the players.
	//************************************************

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
	}

	public void run(ApplicationArguments args) throws Exception {
		Controller game;
		try {
			game = new ConventionalGameController();
			game.initiateGame(args.getSourceArgs());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
