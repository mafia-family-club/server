package org.overmind.mfk.server.repository;

import org.overmind.mfk.server.entry.Game;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 30.05.2017 12:04
 */
public interface GameRepository extends Repository<Game, Long> {

    Game save(Game game);

    Optional<Game> findOne(Long id);

}
