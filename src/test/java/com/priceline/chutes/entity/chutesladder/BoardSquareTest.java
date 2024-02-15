package com.priceline.chutes.entity.chutesladder;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardSquareTest {

    @Test
    public void aChuteShouldSkipSquaresReversed(){
        BoardSquare square = new BoardSquare(true, false, 10);
        assertTrue(square.getNumberSquaresToSkip() < 0);
    }

    @Test
    public void givenChute_whenGetNumberSquaresToSkip_thenGetCorrectNegativeNumber(){
        BoardSquare square = new BoardSquare(true, false, 75);
        assertEquals(-75, square.getNumberSquaresToSkip());
    }

    @Test
    public void givenLadder_whenGetNumberSquaresToSkip_thenGetCorrectPositiveNumber(){
        BoardSquare square = new BoardSquare(false, true, 45);
        assertEquals(45, square.getNumberSquaresToSkip());
    }

    @Test
    public void givenPlainSquareWithZeroSkipNumber_whenGetNumberSquaresToSkip_thenGetZero(){
        BoardSquare square = new BoardSquare(false, false, 0);
        assertEquals(0, square.getNumberSquaresToSkip());
    }

    @Test
    public void givenPlainSquareWithWronglySetSkipNumber_whenGetNumberSquaresToSkip_thenGetZero(){
        BoardSquare square = new BoardSquare(false, false, 11);
        assertEquals(0, square.getNumberSquaresToSkip());
    }

}
