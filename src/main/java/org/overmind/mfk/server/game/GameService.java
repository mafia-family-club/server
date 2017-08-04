package org.overmind.mfk.server.game;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 30.05.2017 12:02
 */
@Service
public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    Game save(Game game) {
        return repository.save(game);
    }

    Game findOne(Long id) throws GameNotFoundException {
        return repository.findOne(id)
            .orElseThrow(
                () -> new GameNotFoundException(
                    MessageFormat.format("Game with id ''{0}'' not found", id)
                )
            );
    }
}
