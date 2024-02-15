package com.priceline.chutes.entity.chutesladder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {

    //NOTE: added a SLF4J logger to log info and errors via the logging facility.
    private static final Logger LOG = LoggerFactory.getLogger(Player.class);

    //NOTE: Created an 'entity' package to better organize the classes.
    // The package 'entity' archives all supporting entity classes, while the main class 'Game' remains at the root directory.

    //NOTE: To achieve a better 'encapsulation' of properties in the classes, explicitly set the class 'properties'
    // to be 'private', and added missing accessors (getters and setters) for those properties
    // so that the properties can be accessed by other object via the accessor methods.
    private String name;
    private int position = 0;

    //NOTE: In each class, created a base constructor and set the modifier to be 'public'
    // so that an external class can instantiate this target class.
    private Player(){ // NOTE: By setting this base constructor as 'private', we can block the case where a player is instantiated without a name.
        super();
    }

    public Player(String name){
        this.name = name;
    }

    //NOTE: getters and setters of class properties can be useful for the extensibility and scalability of the application.
    // Often, 'unit tests' can benefit from the 'getters and setters' provided for the properties, to test different use-cases extensively.
    // Also, as the application grows, there arises more use-cases where we need to access the properties via accessor methods.

    public String getName() {
        return name;
    }

    //NOTE: about 'setName()'
    // To maintain the contract (where a name must be provided when a Player object is instantiated and should not be changed afterwards),
    // we do not provide a name's 'setter' in this class.

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
