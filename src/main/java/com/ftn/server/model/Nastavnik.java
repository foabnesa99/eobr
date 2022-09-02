package com.ftn.server.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Nastavnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Korisnik kor;

    private NastavnikRole nastavnikRole;
}
