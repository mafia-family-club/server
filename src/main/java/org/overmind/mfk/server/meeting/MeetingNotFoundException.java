package org.overmind.mfk.server.meeting;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.08.2017 13:07
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class MeetingNotFoundException extends Exception {

    MeetingNotFoundException(String message) {
        super(message);
    }

}
