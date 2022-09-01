package com.ftn.server.repository;

import com.ftn.server.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findKorisnikByKorisnickoIme(String korisnickoIme);
}
