package com.ftn.server.util.exceptions;

public class KorisnikMissingException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Trazeni korisnik ne postoji!";
    }

}
