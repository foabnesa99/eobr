package com.ftn.server.repository;

import com.ftn.server.model.Nastavnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NastavnikRepository extends JpaRepository<Nastavnik, Long> {

}
