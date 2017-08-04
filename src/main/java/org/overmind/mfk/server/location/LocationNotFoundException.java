package org.overmind.mfk.server.location;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 28.05.2017 21:57
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class LocationNotFoundException extends Exception {

    LocationNotFoundException(String message) {
        super(message);
    }

}
