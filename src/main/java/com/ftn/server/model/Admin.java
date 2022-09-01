package com.ftn.server.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Admin {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Korisnik kor;

}
