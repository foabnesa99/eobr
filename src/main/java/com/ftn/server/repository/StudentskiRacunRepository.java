package com.ftn.server.repository;

import com.ftn.server.model.student.StudentskiRacun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentskiRacunRepository extends JpaRepository<StudentskiRacun, Long> {

}
