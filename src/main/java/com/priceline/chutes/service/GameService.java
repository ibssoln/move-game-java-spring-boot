package com.priceline.chutes.service;

public interface GameService { //NOTE: This is an 'interface'.

    //NOTE: For extensibility, created interfaces to be implemented by the concrete classes.
    // This interface is to be implemented by the variation of game services.

    String initiateGame(String[] gameParams) throws Exception;

}
