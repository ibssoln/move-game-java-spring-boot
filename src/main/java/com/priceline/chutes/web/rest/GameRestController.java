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
import org.springframework.web.client.HttpClientErrorException;

import java.util.Objects;

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
        String winnerName = "";
        try {
            if (Objects.isNull(chutesLadderRequest.getPlayerNames())) {
                return new ResponseEntity<>(ChutesLadderResponse.builder().error("Please provide the names of the players").build(), HttpStatus.BAD_REQUEST);
            } else if (chutesLadderRequest.getPlayerNames().length < 2) {
                return new ResponseEntity<>(ChutesLadderResponse.builder().error("Please provide at least 2 players names.").build(), HttpStatus.BAD_REQUEST);
            } else if (chutesLadderRequest.getPlayerNames().length > 4) {
                return new ResponseEntity<>(ChutesLadderResponse.builder().error("This game supports up to 4 players.").build(), HttpStatus.BAD_REQUEST);
            }
            winnerName = chutesLadderGameService.initiateGame(chutesLadderRequest.getPlayerNames());
        }catch(Exception e){
            return new ResponseEntity<>(ChutesLadderResponse.builder().error("An unexpected error occurred. Please try again.").build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(ChutesLadderResponse.builder().winner(winnerName).build(), HttpStatus.OK);
    }

}
