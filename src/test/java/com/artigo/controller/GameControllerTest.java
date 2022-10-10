package com.artigo.controller;

import com.artigo.domain.game.Game;
import com.artigo.service.GameService;
import com.artigo.util.GameCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class GameControllerTest {
    @InjectMocks //anotação para a classe que deve ser testada
    private GameController gameController;

    @Mock //anotação para usar as classes usadas na classe testada
    private GameService gameServiceMock;

    @BeforeEach
    void setUp(){
        // cria uma lista válida e paginada de games
        PageImpl<Game> gamePage = new PageImpl<>(List.of(GameCreator.createValidGame()));
        // toda a vez que a controller chamar esse serviço, ele vai retornar uma lista criada manualmente e paginada de games validos
        BDDMockito.when(gameServiceMock.listAll(ArgumentMatchers.any()))
                .thenReturn(gamePage);
    }
    @Test
    @DisplayName("LIST: Returns list of games inside page object when successful ")
    void list_ReturnsListOfGamesInsidePageObject_WhenSuccessful(){
        String expectedName = GameCreator.createValidGame().getName();

        Page<Game> gamePage = gameController.list(null).getBody();
        System.out.println(gamePage);
        Assertions.assertThat(gamePage).isNotNull();

    }

}