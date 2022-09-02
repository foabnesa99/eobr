package com.ftn.server.service;

import com.ftn.server.model.Korisnik;
import com.ftn.server.model.dto.korisnik.KorisnikCreateRequest;
import com.ftn.server.model.dto.korisnik.KorisnikUpdateRequest;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;

public interface KorisnikService {
    Korisnik getKorisnikByUsername(String username);

    Korisnik getKorisnikByUsernameRequired(String username) throws ValidationException;

    Korisnik fetchLoggedUser();

    Korisnik addUser(KorisnikCreateRequest request);

    Korisnik updateUser(Long id, @Valid KorisnikUpdateRequest updateRequest);

    List<Korisnik> fetchAllActive();

    void enableUser(@Valid Long id);

    void disableUser(@Valid Long id);

    void deleteUser(@Valid Long id);
}
