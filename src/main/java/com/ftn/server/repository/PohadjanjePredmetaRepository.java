package com.ftn.server.repository;

import com.ftn.server.model.predmet.PohadjanjePredmeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PohadjanjePredmetaRepository extends JpaRepository<PohadjanjePredmeta, Long> {

}
