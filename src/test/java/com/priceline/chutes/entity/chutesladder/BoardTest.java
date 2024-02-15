package com.priceline.chutes.entity.chutesladder;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void givenBoard_whenGet1stSquare_thenFetchCorrectBoardSquare(){
        Board board = new Board();
        assertEquals(37, board.getSquareAtPosition(1).getNumberSquaresToSkip());
        assertTrue(board.getSquareAtPosition(1).isLadder());
    }

    @Test
    public void givenBoard_whenGet80thSquare_thenFetchCorrectBoardSquare(){
        Board board = new Board();
        assertEquals(20, board.getSquareAtPosition(80).getNumberSquaresToSkip());
        assertFalse(board.getSquareAtPosition(80).isChute());
        assertTrue(board.getSquareAtPosition(80).isLadder());
    }

    @Test
    public void givenBoard_whenGet100thSquare_thenFetchCorrectBoardSquare(){
        Board board = new Board();
        assertEquals(0, board.getSquareAtPosition(100).getNumberSquaresToSkip());
        assertFalse(board.getSquareAtPosition(100).isChute());
        assertFalse(board.getSquareAtPosition(100).isLadder());
    }

    //NOTE: test for out-of-range index
    @Test
    public void givenBoard_whenGet0thSquare_thenReturnNull(){
        Board board = new Board();
        assertNull(board.getSquareAtPosition(0));
    }

    //NOTE: test for out-of-range index
    @Test
    public void givenBoard_whenGet101thSquare_thenReturnNull(){
        Board board = new Board();
        assertNull(board.getSquareAtPosition(101));
    }

    //NOTE: test for the immutability.
    @Test
    public void givenBoard_whenGetSquares_thenReturnsCorrectSquareThatIsImmutable(){
        Board board = new Board();
        List<BoardSquare> squares = board.getSquares();
        assertEquals(100, squares.size());
        squares = null; // Check the immutability.
        assertEquals(100, board.getSquares().size());
    }

}
