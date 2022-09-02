package com.ftn.server.repository;

import com.ftn.server.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findKorisnikByKorisnickoIme(String korisnickoIme);

    List<Korisnik> findAllByActiveIsTrueAndDeletedIsFalse();
}
