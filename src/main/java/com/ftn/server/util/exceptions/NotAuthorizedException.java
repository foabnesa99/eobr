package com.ftn.server.util.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotAuthorizedException extends ServiceException {

    public NotAuthorizedException(String message) {
        super(message);
    }

}
