package guru.springframework.sbjokeapp;

import guru.springframework.sbjokeapp.controllers.JokesController;
import guru.springframework.sbjokeapp.services.JokeService;


import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class SbJokeAppApplicationTests {

    @Mock
    private JokeService jokeService;
    @Mock
    private Model model;
    private JokesController jokesController = new JokesController(jokeService);

    @BeforeEach
    void setup(){
        jokesController = new JokesController(jokeService);
    }

    @Test
    void testJokeService(){
        String uuidJoke = UUID.randomUUID().toString();
        when(jokeService.getRandomJoke()).thenReturn(uuidJoke);
        assertThat(jokesController.getJoke(model)).asString().isEqualTo("joke");
    }

}
