package com.ftn.server.util.exceptions;

public class UsernameExistsException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Korisnik sa trazenim korisnickim imenom vec postoji!";
    }

}
