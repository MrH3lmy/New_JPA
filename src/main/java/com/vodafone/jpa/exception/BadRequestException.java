package com.vodafone.jpa.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends APIException {
    public BadRequestException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
