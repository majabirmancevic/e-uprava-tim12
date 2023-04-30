package com.ftn.euprava.ambulanta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptableException extends RuntimeException {
    public NotAcceptableException(String message) {
        super(message);
    }
}
