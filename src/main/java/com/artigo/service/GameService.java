package com.artigo.service;

import com.artigo.exception.BadRequestException;
import com.artigo.domain.game.Game;
//import com.artigo.domain.mapper.mapping.GameMapper;
import com.artigo.mapper.mapping.GameMapper;
import com.artigo.mapper.requests.GamePostRequestBody;
import com.artigo.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;
     private GameMapper gameMapper = GameMapper.INSTANCE;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional
    public Game save(GamePostRequestBody gamePostRequestBody) {
        gamePostRequestBody.setCategoria(gamePostRequestBody.getCategoria().toUpperCase());
        return gameRepository.save(gameMapper.toGame(gamePostRequestBody));
    }

    public Page<Game> listAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    public List<Game> listAllNonPageable() {
        return gameRepository.findAll();
    }

    public List<Game> findByName(String name) {
        return gameRepository.findByName(name);
    }

    public Game findByIdOrThrowBadRequestException(long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Game not Found"));
    }

    public void delete(long id) {
        gameRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    /*
    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }*/
}
