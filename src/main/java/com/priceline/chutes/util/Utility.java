package com.priceline.chutes.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utility {

    //NOTE: Created a util package and Utility class to store a static non-state functions to be used as helper methods.

    //NOTE: added a SLF4J logger to log info and errors via the logging facility.
    private static final Logger LOG = LoggerFactory.getLogger(Utility.class);

    //NOTE: the 'private' modifier
    private Utility() { //NOTE: explicitly set this no-arg constructor to be 'private', to prevent an external user from instantiating an object of this class.
        super();
    }

    public static void logInfo(Object o){
        LOG.info(o.toString());
    }

}
