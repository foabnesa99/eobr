package com.ftn.server.model.predmet;

import com.ftn.server.model.student.Student;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class PohadjanjePredmeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Predmet predmet;

    @ManyToOne
    private Student student;

}
