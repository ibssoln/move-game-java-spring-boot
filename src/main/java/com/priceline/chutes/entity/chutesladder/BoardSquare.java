package com.priceline.chutes.entity.chutesladder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardSquare {

    //NOTE: added a SLF4J logger to log info and errors via the logging facility.
    private static final Logger LOG = LoggerFactory.getLogger(BoardSquare.class);

    //NOTE: Created an 'entity' package to better organize the classes.
    // The package 'entity' archives all supporting entity classes, while the main class 'Game' remains at the root directory.

    //NOTE: To achieve a better 'encapsulation' of properties in the classes, explicitly set the class 'properties'
    // to be 'private', and added missing accessors (getters and setters) for those properties
    // so that the properties can be accessed by other object via the accessor methods.

    private boolean isChute;
    private boolean isLadder;
    private int numberSquaresToSkip;

    //NOTE: In each class, created a base constructor and set the modifier to be 'public'
    // so that an external class can instantiate this target class.
    public BoardSquare(){
        this(false, false, 0);
    }
    public BoardSquare(boolean isChute, boolean isLadder, int numberSquaresToSkip){
        this.isChute = isChute;
        this.isLadder = isLadder;
        this.numberSquaresToSkip = numberSquaresToSkip;
    }

    //NOTE: Does not provide 'setters' to maintain the immutability of the already created instance.

    public boolean isChute() {
        return isChute;
    }

    public boolean isLadder() {
        return isLadder;
    }

    public int getNumberSquaresToSkip() {
        if (isLadder) {
            return numberSquaresToSkip;
        } else if (isChute) {
            return numberSquaresToSkip * -1;
        } else {
            return 0;
        }
    }

}
