package com.ftn.server.model;

import com.ftn.server.model.student.StudentskiRacun;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Transakcija {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    private StudentskiRacun racun;
    private Double iznos;

    private TipTransakcije tipTransakcije;

}
