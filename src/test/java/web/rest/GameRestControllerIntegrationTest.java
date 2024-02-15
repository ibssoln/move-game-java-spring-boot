package web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.priceline.chutes.GameApplication;
import com.priceline.chutes.dto.chutesladder.ChutesLadderRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = GameApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
public class GameRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenPlayersNames_whenPlayAndGetWinner_thenStatus200WithWinner()
            throws Exception {
        ChutesLadderRequest payload = ChutesLadderRequest.builder().playerNames(new String[]{"Gab", "Michael"}).build();
        mvc.perform(MockMvcRequestBuilders
                        .post("/game/chutesladder")
                        .content(asJsonString(payload))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.winner").exists());
    }

    @Test
    public void givenOnly1PlayerName_whenPlayAndGetWinner_thenStatus400WithErrorMessage()
            throws Exception {
        ChutesLadderRequest payload = ChutesLadderRequest.builder().playerNames(new String[]{"Gab"}).build();
        mvc.perform(MockMvcRequestBuilders
                        .post("/game/chutesladder")
                        .content(asJsonString(payload))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Please provide at least 2 players names."));
    }

    @Test
    public void given5PlayersNames_whenPlayAndGetWinner_thenStatus400WithErrorMessage()
            throws Exception {
        ChutesLadderRequest payload = ChutesLadderRequest.builder().playerNames(new String[]{"Gab", "Jane", "Michael", "Sandra", "Bob"}).build();
        mvc.perform(MockMvcRequestBuilders
                        .post("/game/chutesladder")
                        .content(asJsonString(payload))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("This game supports up to 4 players."));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
