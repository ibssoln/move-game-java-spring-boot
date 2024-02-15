package com.priceline.chutes.web.rest;

import com.priceline.chutes.service.ChutesLadderGameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameRestController {

    //NOTE: added a SLF4J logger to log info and errors via the logging facility.
    private static final Logger LOG = LoggerFactory.getLogger(GameRestController.class);

    @Autowired
    private ChutesLadderGameService chutesLadderGameService;

    @RequestMapping(value = "/chutesladder", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<String> playAndGetWinner(@RequestParam String[] playerNames) throws Exception {
        String winnerName = chutesLadderGameService.initiateGame(playerNames);
        return new ResponseEntity<>(winnerName, HttpStatus.OK);
    }

}
