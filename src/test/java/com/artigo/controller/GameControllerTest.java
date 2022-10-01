package com.artigo.controller;

import com.artigo.controller.GameController;
import com.artigo.service.GameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class GameControllerTest {
    @InjectMocks //anotação para a classe que deve ser testada
    private GameController gameController;

    @Mock //anotação para usar as classes que são usadas dentro da classe testada
    private GameService gameService;

    @Test
    void test(){

    }

}