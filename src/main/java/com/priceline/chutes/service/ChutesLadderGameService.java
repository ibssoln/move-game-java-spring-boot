package com.priceline.chutes.service;

import com.priceline.chutes.entity.chutesladder.Board;
import com.priceline.chutes.entity.chutesladder.BoardSquare;
import com.priceline.chutes.entity.chutesladder.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import static com.priceline.chutes.constant.GameConstants.RANDOM;
import static com.priceline.chutes.util.Utility.*;

@Service
public class ChutesLadderGameService implements GameService {

    //NOTE: added a SLF4J logger to log info and errors via the logging facility.
    private static final Logger LOG = LoggerFactory.getLogger(ChutesLadderGameService.class);

    //NOTE: this class stores all game control related functionalities. This class was created to better encapsulate the game execution functions
    // that are only related to the 'chutes-and-ladders' game, in order to achieve a maintainability and extensibility for a later extension of the whole application.

    public ChutesLadderGameService() {
        super();
    }

    public String initiateGame(String[] playerNames) throws Exception {
        Player winner = null;
        try {
            //NOTE: Below is a new section of code for processing the main method's parameters (args),
            // to accept a variable number (2 ~4) of players with their names. Based on the players' information, the players instances are created.
            logInfo("1. Let's set the players!");
            List<Player> players = createBasePlayers(playerNames);

            if (!CollectionUtils.isEmpty(players)) {
                //NOTE: Below is a new section of code for determining the play order of the players.
                logInfo("2. Let's determine the order of players to spin!");
                players = determinePlayOrder(players);
                logInfo(">> The determined order of play to spin: " + players.stream().map(player -> player.getName()).collect(Collectors.joining(", ")).toString());

                logInfo("3. Let's play the game!");
                winner = playGame(players);
                logInfo("The winner is: " + winner.getName());
            }
        }catch(Exception e){
            throw new Exception(e);
        }
        return (Objects.nonNull(winner))? winner.getName() : "";
    }

    //NOTE: the algorithm of this spin method's result is closely pertaining to the 'chutes-and-ladders' game. Therefore, moved it to this game controller class,
    // rather than moving it to the Utility class.
    public int spin(){
        return RANDOM.nextInt(6) + 1;
    }

    //NOTE: This createBasePlayers() method was newly added.
    public List<Player> createBasePlayers(String[] playerNames){
        if(playerNames.length<2){
            logInfo("Could not play. Too little number of players. Please enter the names of 2 ~ 4 players.");
            return List.of();
        }else if(playerNames.length>4){
            logInfo("Could not play. Too many number of players. Please enter the names of 2 ~ 4 players.");
            return List.of();
        }
        logInfo("The number players: "+playerNames.length);
        return Arrays.stream(playerNames).map(p -> new Player(p)).collect(Collectors.toList());
    }

    //NOTE: This determinePlayOrder() method was newly added.
    //this method uses a recursive run of the self method to find the definite order of play among all players.
    public List<Player> determinePlayOrder(List<Player> players){
        Map<Integer, List<Player>> spinResults = new HashMap<>();
        //1. each player spins and get their individual number.
        players.stream().forEach(player -> {
            int spinVal = spin();
            logInfo("> Name: "+player.getName()+" - Spin Result: "+spinVal);
            if(Objects.nonNull(spinResults.get(spinVal))){
                spinResults.get(spinVal).add(player);
            }else{
                spinResults.put(spinVal, new ArrayList<>(List.of(player)));
            }
        });
        //2. check to see if there are tied players, and determine the orders among them.
        spinResults.entrySet().stream().forEach(entry -> {
            if (entry.getValue().size() > 1) {
                //NOTE: the one or more tied players are given another opportunities to run the spinner, so that they can determine the distinct order.
                // If there is another tie found in this try, the subset of the tied players do another round running the spinner. This process is recursively
                // processed, until there is no tie among the players.
                List<Player> newOrdered = determinePlayOrder(entry.getValue()); // NOTE: this is a Recursive call
                entry.setValue(newOrdered);
            }
        });
        return spinResults.entrySet().stream()
                .sorted(Map.Entry.<Integer, List<Player>>comparingByKey().reversed())
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
    }

    //NOTE: this method was moved from the Game class.
    public Player playGame(List<Player> players){
        Board board = new Board();
        while(true){
            for (Player currentPlayer : players) {
                int spinResult = spin();
                int nextPosition = currentPlayer.getPosition() + spinResult;
                if (nextPosition > 100) {
                    //NOTE: Fixed a bug. The previous statement, 'break;', was inaccurate based on our business rule.
                    // I have changed it to 'continue;' to fix the logical error.
                    continue; //<-- it was 'break' before, which was a defect.
                }
                BoardSquare nextSquare = board.getSquareAtPosition(nextPosition);
                //NOTE: Added a protection code for a null check upon the nextSquare.
                if(Objects.nonNull(nextSquare)){
                    nextPosition += nextSquare.getNumberSquaresToSkip();
                    if (nextPosition < 100) {
                        currentPlayer.setPosition(nextPosition);
                    } else if (nextPosition == 100) {
                        return currentPlayer;//The winner!
                    }
                }
            }
        }
    }

}
