package com.artigo.controller;

import com.artigo.domain.game.Game;
import com.artigo.mapper.requests.GamePostRequestBody;
import com.artigo.service.GameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Game> save(@RequestBody GamePostRequestBody gamePostRequestBody) {
        return new ResponseEntity<>(gameService.save(gamePostRequestBody), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Game>> list(Pageable pageable) {
        return ResponseEntity.ok(gameService.listAll(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Game>> listAll() {
        return ResponseEntity.ok(gameService.listAllNonPageable());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Game> findById(@PathVariable long id) {
        return ResponseEntity.ok(gameService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Game>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(gameService.findByName(name));
    }



    @DeleteMapping(path = "/admin/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        gameService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody) {
        animeService.replace(animePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/


}
