package com.priceline.chutes.service;

public interface GameService {

    //NOTE: For extensibility, created interfaces to be implemented by the concrete classes.
    // This interface is to be implemented by the variation of game services.

    void initiateGame(String[] gameParams);

}
