package com.ftn.server.repository;

import com.ftn.server.model.predmet.IspitniRok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IspitniRokRepository extends JpaRepository<IspitniRok, Long> {

}
