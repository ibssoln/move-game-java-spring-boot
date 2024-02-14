package com.priceline.chutes;

import com.priceline.chutes.conventionalgame.ConventionalGameController;
import com.priceline.chutes.framework.Controller;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Game implements ApplicationRunner{

	//NOTE: To achieve maintainability and extensibility for a later extension of the whole application, the specific 'chutes-and-ladders' related functionalities
	//have been moved to the new class named 'Controller.java'.

	//NOTE: You can run a game in 2 different ways.
	// 1. By sending a request to the RESTful service endpoint after the Spring Boot server is up and running.
	// 2. By checking the result produced by the play that is automatically run at the time of launching the app or running the gradle build run with the below command.
	// 		gradle run --args="one two three four"

	public static void main(String[] args) {
		SpringApplication.run(Game.class, args);
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
