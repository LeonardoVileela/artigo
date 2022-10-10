package com.artigo.util;


import com.artigo.domain.game.Categoria;
import com.artigo.domain.game.Game;

import java.util.UUID;

public class GameCreator {

    public static Game createGameToBeSaved() {
        return Game.builder()
                .name("God Of War")
                .categoria(Categoria.ACTION)
                .build();
    }

    public static Game createValidGame() {
        return Game.builder()
                .name("God Of War")
                .categoria(Categoria.ACTION)
                .id(UUID.randomUUID())
                .build();
    }

    public static Game createValidUpdatedGame() {
        return Game.builder()
                .name("God Of War 2")
                .categoria(Categoria.ACTION)
                .id(UUID.randomUUID())
                .build();
    }
}
