package com.ftn.server.model.student;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class StudentskiRacun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double raspolozivaSredstva;

    @OneToOne
    private Student korisnik;


}
