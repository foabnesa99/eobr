package com.ftn.server.service.impl;

import com.ftn.server.model.Nastavnik;
import com.ftn.server.model.dto.korisnik.KorisnikCreateRequest;
import com.ftn.server.model.dto.nastavnik.NastavnikCreateRequest;
import com.ftn.server.model.dto.nastavnik.NastavnikUpdateRequest;
import com.ftn.server.repository.NastavnikRepository;
import com.ftn.server.service.KorisnikService;
import com.ftn.server.service.NastavnikService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class NastavnikServiceImpl implements NastavnikService {

    private final KorisnikService korisnikService;

    private final NastavnikRepository nastavnikRepository;

    @Override
    public Nastavnik createNastavnik(NastavnikCreateRequest createRequest) {
        Nastavnik nastavnik = new Nastavnik();
        nastavnik.setKor(korisnikService.addUser(new KorisnikCreateRequest(createRequest.getIme(), createRequest.getDatumRodjenja(), createRequest.getKorisnickoIme(), createRequest.getRole())));
        nastavnik.setNastavnikRole(createRequest.getNastavnikRole());
        return nastavnikRepository.save(nastavnik);
    }

    @Override
    public Nastavnik getById(Long id) {
        return null;
    }

    @Override
    public Nastavnik updateNastavnik(NastavnikUpdateRequest updateRequest) {
        return null;
    }

    @Override
    public void removeNastavnik() {

    }

    @Override
    public void disableNastavnik() {

    }

    @Override
    public void enableNastavnik() {

    }

}
