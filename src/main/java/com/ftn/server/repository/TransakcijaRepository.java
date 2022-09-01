package com.ftn.server.repository;

import com.ftn.server.model.Transakcija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransakcijaRepository extends JpaRepository<Transakcija, Long>{

}
