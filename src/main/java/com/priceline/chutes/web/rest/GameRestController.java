package com.priceline.chutes.web.rest;

import com.priceline.chutes.dto.chutesladder.ChutesLadderResponse;
import com.priceline.chutes.service.ChutesLadderGameService;
import com.priceline.chutes.dto.chutesladder.ChutesLadderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.priceline.chutes.util.Utility.logInfo;

@RestController
@RequestMapping("/game")
public class GameRestController {

    //NOTE: added a SLF4J logger to log info and errors via the logging facility.
    private static final Logger LOG = LoggerFactory.getLogger(GameRestController.class);

    @Autowired
    private ChutesLadderGameService chutesLadderGameService;

    @RequestMapping(value = "/chutesladder", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ChutesLadderResponse> playAndGetWinner(@RequestBody ChutesLadderRequest chutesLadderRequest) throws Exception {
        String winnerName = chutesLadderGameService.initiateGame(chutesLadderRequest.getPlayerNames());
        logInfo(winnerName);
        return new ResponseEntity<>(ChutesLadderResponse.builder().winner(winnerName).build(), HttpStatus.OK);
    }

}
