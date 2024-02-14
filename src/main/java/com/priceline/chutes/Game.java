package com.priceline.chutes;

import com.priceline.chutes.conventionalgame.ConventionalGameController;
import com.priceline.chutes.framework.Controller;

public class Game {

    //************************************************
    //NOTE: You can run a game in 2 different ways.
    // 1. By sending a request to the RESTful service endpoint after the Spring Boot server is up and running.
    // 2. By running a gradle build (gradle run --args="one two three four") in the command line, where the args are the names of the players.
    //************************************************

    //NOTE: To achieve maintainability and extensibility for a later extension of the whole application, the specific 'chutes-and-ladders' related functionalities
    //have been moved to the new class named 'Controller.java'.

    public static void main(String[] args) {
        Controller game;
        try {
            game = new ConventionalGameController();
            game.initiateGame(args);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
