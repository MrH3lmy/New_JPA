package com.vodafone.jpa.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends APIException {
    public ForbiddenException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.FORBIDDEN;
    }
}
