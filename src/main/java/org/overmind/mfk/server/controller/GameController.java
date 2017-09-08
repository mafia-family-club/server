package org.overmind.mfk.server.controller;

import org.overmind.mfk.server.entry.Game;
import org.overmind.mfk.server.exception.GameNotFoundException;
import org.overmind.mfk.server.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 30.05.2017 12:01
 */
@RestController
@RequestMapping("game")
class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("{id}")
    public Game findOne(Long id) throws GameNotFoundException {
        return gameService.findOne(id);
    }

    @PostMapping
    public Game save(@RequestBody Game game) {
        return gameService.save(game);
    }

}
