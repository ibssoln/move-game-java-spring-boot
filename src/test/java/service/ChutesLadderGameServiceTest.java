package service;

import com.priceline.chutes.entity.chutesladder.Player;
import com.priceline.chutes.service.ChutesLadderGameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class ChutesLadderGameServiceTest {

    private String[] playerNames;
    private List<Player> players;

    @BeforeEach
    public void setupTestVars(){
        playerNames = new String[]{"Jane", "Mike", "Sue", "Ben", "Carlos"};
        players = new ArrayList(List.of(new Player("Jane"), new Player("Mike"), new Player("Sue")));
    }

    @Test
    public void given4PlayerNames_whenInitiateGame_thenReturnDetermineOrderPlayGameReturnWinner() throws Exception {
        ChutesLadderGameService service = new ChutesLadderGameService();
        String[] fourPlayers = Arrays.copyOfRange(playerNames, 0, 4);
        String winner = service.initiateGame(fourPlayers);
        assertNotNull(winner);
    }

    @Test
    public void whenSpin_thenReturnNumberBetween1And6BothEndsInclusive(){
        ChutesLadderGameService service = new ChutesLadderGameService();
        int result = service.spin();
        assertTrue(result >= 1);
        assertTrue(result <= 6);
    }

    @Test
    public void given3PlayerNames_whenCreateBasePlayers_thenReturn3Players(){
        ChutesLadderGameService service = new ChutesLadderGameService();
        String[] threePlayers = Arrays.copyOfRange(playerNames, 0, 3);
        List<Player> results = service.createBasePlayers(threePlayers);
        assertNotNull(results);
        assertEquals(3, results.size());
    }

    @Test
    public void given5PlayerNames_whenCreateBasePlayers_thenReturnEmptyList(){
        ChutesLadderGameService service = new ChutesLadderGameService();
        String[] fivePlayers = Arrays.copyOfRange(playerNames, 0, 5);
        List<Player> results = service.createBasePlayers(fivePlayers);
        assertNotNull(results);
        assertEquals(0, results.size());
    }

    @Test
    public void givenOnly1PlayerName_whenCreateBasePlayers_thenReturnEmptyList(){
        ChutesLadderGameService service = new ChutesLadderGameService();
        String[] onePlayer = Arrays.copyOfRange(playerNames, 0, 1);
        List<Player> results = service.createBasePlayers(onePlayer);
        assertNotNull(results);
        assertEquals(0, results.size());
    }

    @Test
    public void givenPlayers_whenDeterminePlayOrder_thenReturnPlayersInDeterminedOrder(){
        ChutesLadderGameService service = new ChutesLadderGameService();
        assertNotNull(service.determinePlayOrder(players));
        assertEquals(3, service.determinePlayOrder(players).size());
    }

    @Test
    public void givenPlayers_whenPlayGame_thenReturnWinner(){
        ChutesLadderGameService service = new ChutesLadderGameService();
        assertNotNull(service.playGame(players));
    }


}
