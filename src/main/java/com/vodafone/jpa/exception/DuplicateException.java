package com.vodafone.jpa.exception;

import org.springframework.http.HttpStatus;

public class DuplicateException extends APIException {
    public DuplicateException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }
}
