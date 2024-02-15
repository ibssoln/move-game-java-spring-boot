//package web.rest;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.mockito.Mockito.when;
//
//import com.priceline.chutes.GameApplication;
//import com.priceline.chutes.web.rest.GameRestController;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
////import com.fasterxml.jackson.databind.ObjectMapper;
////import com.priceline.chutes.GameApplication;
////import com.priceline.chutes.dto.chutesladder.ChutesLadderRequest;
////import com.priceline.chutes.service.ChutesLadderGameService;
////import com.priceline.chutes.web.rest.GameRestController;
////import org.junit.Test;
////import org.junit.runner.RunWith;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
////import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
////import org.springframework.boot.test.mock.mockito.MockBean;
////import org.springframework.http.MediaType;
////import org.springframework.test.context.ContextConfiguration;
////import org.springframework.test.context.TestPropertySource;
////import org.springframework.test.context.junit4.SpringRunner;
////import org.springframework.test.web.servlet.MockMvc;
////import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
////import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
////
////import static org.hamcrest.Matchers.hasSize;
////import static org.mockito.BDDMockito.given;
////import static org.mockito.Mockito.when;
////import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
////import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
////import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
////@ContextConfiguration(classes = GameRestController.class)
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////@SpringBootTest(classes = GameApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////@ContextConfiguration(classes = {GameApplication.class})
//
////@RunWith(SpringRunner.class)
////@ContextConfiguration(classes={GameApplication.class, ChutesLadderGameService.class, GameRestController.class})
////@WebMvcTest(GameRestController.class)
////@TestPropertySource(properties = {"logging.level.root=info"})
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.priceline.chutes.service.ChutesLadderGameService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes= GameApplication.class)
//@WebMvcTest(GameRestController.class)
//public class GameRestControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private ChutesLadderGameService service;
//
//    @TestConfiguration
//    static class ChutesLadderGameServiceTestContextConfiguration {
//        @Bean
//        public ChutesLadderGameService service() {
//            return new ChutesLadderGameService() {
//            };
//        }
//    }
//
//    @Test
//    public void shouldReturn401() throws Exception {
//        when(service.initiateGame(new String[]{"Alex", "Mike"})).thenReturn("Alex");
//        mvc.perform(MockMvcRequestBuilders.post("/game/chutesladder")).andExpect(status().isOk());
//    }
//
////    @Test
////    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
////            throws Exception {
//
//////        given(service.initiateGame(new String[]{"Alex", "Mike"})).willReturn("Alex");
////        ChutesLadderRequest payload = ChutesLadderRequest.builder().playerNames(new String[]{"Alex", "Mike"}).build();
////        mvc.perform(MockMvcRequestBuilders
////                        .post("/game/chutesladder")
////                        .content(asJsonString(payload))
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .accept(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(MockMvcResultMatchers.jsonPath("$.winner").exists());
////
////        mvc.perform(post("/api/employees")
////                        .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk());
//////                .andExpect(jsonPath("$", hasSize(1)));
//////                .andExpect(jsonPath("$[0].name", is(alex.getName())));
////    }
//
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
