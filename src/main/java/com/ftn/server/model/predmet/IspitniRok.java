package com.ftn.server.model.predmet;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class IspitniRok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    private LocalDate datumPocetkaRoka;

    private LocalDate datumKrajaRoka;
}
