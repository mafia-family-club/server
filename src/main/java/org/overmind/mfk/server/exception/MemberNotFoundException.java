package org.overmind.mfk.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 28.05.2017 11:50
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MemberNotFoundException extends Exception {

    public MemberNotFoundException(String message) {
        super(message);
    }

}
