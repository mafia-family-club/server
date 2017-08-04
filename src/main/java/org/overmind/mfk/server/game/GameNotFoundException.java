package org.overmind.mfk.server.game;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 30.05.2017 12:06
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class GameNotFoundException extends Exception {

    GameNotFoundException(String message) {
        super(message);
    }

}
