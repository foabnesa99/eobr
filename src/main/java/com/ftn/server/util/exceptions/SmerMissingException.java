package com.ftn.server.util.exceptions;

public class SmerMissingException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Trazeni smer ne postoji!";
    }

}
