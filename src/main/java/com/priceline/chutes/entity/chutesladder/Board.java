package com.priceline.chutes.entity.chutesladder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.priceline.chutes.constant.GameConstants.CHUTES_LADDER_SQUARES;

public class Board {

    //NOTE: added a SLF4J logger to log info and errors via the logging facility.
    private static final Logger LOG = LoggerFactory.getLogger(Board.class);

    //NOTE: Created an 'entity' package to better organize the classes.
    // The package 'entity' archives all supporting entity classes, while the main class 'Game' remains at the root directory.

    //NOTE: Moved 'specialSquares' in the Board class to the constant class (and set it to be 'public static final'),
    // since this data is fixed and final for the given business rules. Also, refactored the property name to use only
    // the capital letters as it's a constant variable.

    //NOTE: set the modifier to be 'public' so that an external class can instantiate this target class.
    public Board() {
        super();
        //NOTE: Moved 'squares' in the Board class to the constant class (and set it to be 'public static final'),
        //  since this data is fixed and final for the given business rules.
        //  Also, refactored the property name to use only the capital letters as it's a constant variable.
    }

    //NOTE: changed the modifier scope to 'public'.
    public BoardSquare getSquareAtPosition(int i){
        //NOTE: added a range protection code where a request for an out-of-range index returns null,
        // instead of throwing an exception.
        return (i >= 1 && i <= 100)? CHUTES_LADDER_SQUARES.get(i-1) : null;
    }

    //NOTE: getters and setters of class properties can be useful for the extensibility and scalability of the application.
    // Often, 'unit tests' can benefit from the 'getters and setters' provided for the properties, to test different use-cases extensively.
    // Also, as the application grows, there arises more use-cases where we need to access the properties via accessor methods.

    //NOTE: In order to maintain 'immutability', when we send a list to an external entity,
    // we need to wrap the existing list with a new 'ArrayList' once again and send a 'copy' of it, not to send the original list as a reference.
    public List<BoardSquare> getSquares() {
        return new ArrayList<>(CHUTES_LADDER_SQUARES); //NOTE: for immutability, we need to return a new copy of the existing list object, not the list itself.
    }

    //NOTE: We will not have/allow a 'setSquares()' method, because we want to lock the squares once it's made.

}
