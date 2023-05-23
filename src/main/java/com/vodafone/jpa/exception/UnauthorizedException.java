package com.vodafone.jpa.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends APIException {
    public UnauthorizedException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
