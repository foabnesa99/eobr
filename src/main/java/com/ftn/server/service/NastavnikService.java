package com.ftn.server.service;

import com.ftn.server.model.Nastavnik;
import com.ftn.server.model.dto.nastavnik.NastavnikCreateRequest;
import com.ftn.server.model.dto.nastavnik.NastavnikUpdateRequest;

public interface NastavnikService {

    Nastavnik createNastavnik(NastavnikCreateRequest createRequest);

    Nastavnik getById(Long id);

    Nastavnik updateNastavnik(NastavnikUpdateRequest updateRequest);

    void removeNastavnik();

    void disableNastavnik();

    void enableNastavnik();

}
