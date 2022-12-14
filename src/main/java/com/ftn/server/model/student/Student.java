package com.ftn.server.model.student;

import com.ftn.server.model.Korisnik;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student {

    @OneToOne
    private Korisnik user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
