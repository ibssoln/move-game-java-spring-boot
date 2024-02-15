package com.priceline.chutes;

import com.priceline.chutes.service.ChutesLadderGameService;
import com.priceline.chutes.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {

    //NOTE: added a SLF4J logger to log info and errors via the logging facility.
    private static final Logger LOG = LoggerFactory.getLogger(Game.class);

    //************************************************
    //NOTE: You can run a game in 2 different ways.
    // 1. By sending a request to the RESTful service endpoint after the Spring Boot server is up and running.
    // 2. By running a gradle build (gradle run --args="one two three four") in the command line, where the args are the names of the players.
    //************************************************

    //NOTE: To achieve maintainability and extensibility for a later extension of the whole application, the specific 'chutes-and-ladders' related functionalities
    //have been moved to the new class named 'Controller.java'.

    public static void main(String[] args) {
        GameService game;
        try {
            game = new ChutesLadderGameService();
            game.initiateGame(args);
        } catch (Exception e) {
            //NOTE: added a SLF4J logger to log info and errors via the logging facility.
            LOG.error("An Exception has occurred: {}, {}", e.getCause(), e.getMessage());
            e.printStackTrace();
        }
    }

}
