package web.rest;

import com.priceline.chutes.dto.chutesladder.ChutesLadderRequest;
import com.priceline.chutes.dto.chutesladder.ChutesLadderResponse;
import com.priceline.chutes.web.rest.GameRestController;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import com.priceline.chutes.service.ChutesLadderGameService;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(EasyMockRunner.class)
public class GameRestControllerTest {

    private String[] playerNames;

    @Before
    public void setupTestVars(){
        playerNames = new String[]{"Jane", "Mike", "Sue", "Ben", "Carlos"};
    }

    @TestSubject
    GameRestController controller = new GameRestController();

    @Mock
    private ChutesLadderGameService service;

    @Test
    public void given4PlayerNames_whenPlayAndGetWinner_thenReturnWinnerName() throws Exception {
        String winnerName = "Mike";
        String[] fourPlayers = Arrays.copyOfRange(playerNames, 0, 4);
        ChutesLadderRequest request = ChutesLadderRequest.builder().playerNames(fourPlayers).build();
        EasyMock.expect(service.initiateGame(fourPlayers)).andReturn(winnerName);
        EasyMock.replay(service);
        ResponseEntity<ChutesLadderResponse> response = controller.playAndGetWinner(request);
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        assertEquals(winnerName, response.getBody().getWinner());
    }

    @Test
    public void givenOnlyOnePlayer_whenPlayAndGetWinner_thenReturnErrorMessageNullWinner() throws Exception {
        String[] onePlayer = Arrays.copyOfRange(playerNames, 0, 1);
        ChutesLadderRequest request = ChutesLadderRequest.builder().playerNames(onePlayer).build();
        ResponseEntity<ChutesLadderResponse> response = controller.playAndGetWinner(request);
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(400), response.getStatusCode());
        assertNull(response.getBody().getWinner());
        assertEquals("Please provide at least 2 players names.", response.getBody().getError());
    }

    @Test
    public void givenFivePlayerNames_whenPlayAndGetWinner_thenReturnErrorMessageNullWinner() throws Exception {
        String[] fivePlayers = Arrays.copyOfRange(playerNames, 0, 5);
        ChutesLadderRequest request = ChutesLadderRequest.builder().playerNames(fivePlayers).build();
        ResponseEntity<ChutesLadderResponse> response = controller.playAndGetWinner(request);
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(400), response.getStatusCode());
        assertNull(response.getBody().getWinner());
        assertEquals("This game supports up to 4 players.", response.getBody().getError());
    }

    @Test
    public void given4PlayerNames_whenPlayAndGetWinnerThrowsException_thenReturnErrorMessageNullWinner() throws Exception {
        String winnerName = "Mike";
        String[] fourPlayers = Arrays.copyOfRange(playerNames, 0, 4);
        ChutesLadderRequest request = ChutesLadderRequest.builder().playerNames(fourPlayers).build();
        EasyMock.expect(service.initiateGame(fourPlayers)).andThrow(new RuntimeException());
        EasyMock.replay(service);
        ResponseEntity<ChutesLadderResponse> response = controller.playAndGetWinner(request);
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(500), response.getStatusCode());
        assertNull(response.getBody().getWinner());
        assertEquals("An unexpected error occurred. Please try again.", response.getBody().getError());
    }

}
