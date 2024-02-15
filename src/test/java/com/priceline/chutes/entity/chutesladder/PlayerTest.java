package com.priceline.chutes.entity.chutesladder;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void givenInstantiatedPlayerWithName_whenGetNameGetPosition_thenReturnsCorrectNameAndPosition0(){
        Player player = new Player("Maya");
        assertEquals("Maya", player.getName()); // Check name
        assertEquals(0, player.getPosition()); // Check position
    }

    @Test
    public void givenInstantiatedPlayerWithName_whenSetNewPosition_thenReturnsNewPosition(){
        Player player = new Player("Michael");
        player.setPosition(26);
        assertEquals(26, player.getPosition()); // Check position
    }

}
