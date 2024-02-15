package com.priceline.chutes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class SnakeLadderGameService implements GameService {

    //TODO: This class is to be used for another variation of game.
    private static final Logger LOG = LoggerFactory.getLogger(SnakeLadderGameService.class);
    public SnakeLadderGameService() {
        super();
    }

    @Override
    public String initiateGame(String[] gameParams) throws Exception {
        return null;
    }

}
