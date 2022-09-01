package com.ftn.server.repository;

import com.ftn.server.model.predmet.Ispit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IspitRepository extends JpaRepository<Ispit, Long> {
}
