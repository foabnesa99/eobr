package com.ftn.server.model.predmet;

import com.ftn.server.model.Nastavnik;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Predmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    @ManyToOne
    private Nastavnik predmetniProfesor;

    @ManyToOne
    private Smer smer;


}
