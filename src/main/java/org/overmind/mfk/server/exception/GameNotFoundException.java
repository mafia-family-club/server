package org.overmind.mfk.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 30.05.2017 12:06
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GameNotFoundException extends Exception {

    public GameNotFoundException(String message) {
        super(message);
    }

}
