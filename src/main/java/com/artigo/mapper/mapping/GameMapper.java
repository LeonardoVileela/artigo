package com.artigo.mapper.mapping;

import com.artigo.domain.game.Game;
import com.artigo.mapper.requests.GamePostRequestBody;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(source = "gamePostRequestBody.categoria", target = "categoria")
    Game toGame(GamePostRequestBody gamePostRequestBody);
}
