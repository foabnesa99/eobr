package com.ftn.server.model.predmet;

import com.ftn.server.model.student.Student;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class PohadjanjeIspita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ispit ispit;

    @ManyToOne
    private Student student;

    private Integer bodovi;

    private Integer ocena;

}
