package com.ftn.server.repository;

import com.ftn.server.model.predmet.PohadjanjeIspita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PohadjanjeIspitaRepository extends JpaRepository<PohadjanjeIspita, Long> {

}
