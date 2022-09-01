package com.ftn.server.model.predmet;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class Ispit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime vremeIspita;

    @ManyToOne
    private IspitniRok ispitniRok;

    @OneToOne
    private Predmet predmet;

}
