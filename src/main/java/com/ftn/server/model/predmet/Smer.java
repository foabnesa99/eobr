package com.ftn.server.model.predmet;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Smer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate datumPocetkaStudija;

    private LocalDate datumKrajaStudija;
}
