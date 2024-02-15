package com.priceline.chutes.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameRestController {

    //NOTE: added a SLF4J logger to log info and errors via the logging facility.
    private static final Logger LOG = LoggerFactory.getLogger(GameRestController.class);



}
