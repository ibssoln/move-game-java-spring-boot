package service;

import com.priceline.chutes.entity.chutesladder.Player;
import com.priceline.chutes.service.ChutesLadderGameService;
import org.easymock.EasyMockRunner;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(EasyMockRunner.class)
public class ChutesLadderGameServiceTest {

    @TestSubject
    private ChutesLadderGameService service = new ChutesLadderGameService();

    private String[] playerNames;
    private List<Player> players;

    @Before
    public void setupTestVars(){
        playerNames = new String[]{"Jane", "Mike", "Sue", "Ben", "Carlos"};
        players = new ArrayList(List.of(new Player("Jane"), new Player("Mike"), new Player("Sue")));
    }


    @Test
    public void given4PlayerNames_whenInitiateGame_thenReturnDetermineOrderPlayGameReturnWinner() throws Exception {
        String[] fourPlayers = Arrays.copyOfRange(playerNames, 0, 4);
        String winner = service.initiateGame(fourPlayers);
        assertNotNull(winner);
    }

    @Test
    public void whenSpin_thenReturnNumberBetween1And6BothEndsInclusive(){
        int result = service.spin();
        assertTrue(result >= 1);
        assertTrue(result <= 6);
    }

    @Test
    public void given3PlayerNames_whenCreateBasePlayers_thenReturn3Players(){
        String[] threePlayers = Arrays.copyOfRange(playerNames, 0, 3);
        List<Player> results = service.createBasePlayers(threePlayers);
        assertNotNull(results);
        assertEquals(3, results.size());
    }

    @Test
    public void given5PlayerNames_whenCreateBasePlayers_thenReturnEmptyList(){
        String[] fivePlayers = Arrays.copyOfRange(playerNames, 0, 5);
        List<Player> results = service.createBasePlayers(fivePlayers);
        assertNotNull(results);
        assertEquals(0, results.size());
    }

    @Test
    public void givenOnly1PlayerName_whenCreateBasePlayers_thenReturnEmptyList(){
        String[] onePlayer = Arrays.copyOfRange(playerNames, 0, 1);
        List<Player> results = service.createBasePlayers(onePlayer);
        assertNotNull(results);
        assertEquals(0, results.size());
    }

    @Test
    public void givenPlayers_whenDeterminePlayOrder_thenReturnPlayersInDeterminedOrder(){
        assertNotNull(service.determinePlayOrder(players));
        assertEquals(3, service.determinePlayOrder(players).size());
    }

    @Test
    public void givenPlayers_whenPlayGame_thenReturnWinner(){
        assertNotNull(service.playGame(players));
    }

}
