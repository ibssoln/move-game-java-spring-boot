package com.priceline.chutes.service;

import org.springframework.stereotype.Service;
import static com.priceline.chutes.constant.GameConstants.RANDOM;

@Service
public class SpinRollService {

    //TODO:
    // This service provides only the spin results.
    // The "reason" why this service is separated is for the versatility of the testing to switch between a fixed result or random results.
    // By separating this service from the actual game service, when testing code, we can easily intervene (= make a pointcut) and mock the result by using a mock object.

    //NOTE:
    // The algorithm of this spin method is closely pertaining to the 'chutes-and-ladders' game.
    // Hence, clarify the name by adding the info.
    //NOTE:
    // This spin method in this service is not yet used. It's because we have to support one service data run at this point, which is triggered by
    // the gradle run for the game. If this game is supported only via spring boot, we can take advantage of this separate service.
    public int chutesAndLaddersSpin(){
        return RANDOM.nextInt(6) + 1;
    }

}
