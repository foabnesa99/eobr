package com.ftn.server.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import static javax.persistence.EnumType.STRING;

@Entity
@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String ime;

    private String prezime;

    private LocalDate datumRodjenja;

    private String korisnickoIme;

    private String password;

    private UserRole role;

    @Builder.Default
    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean active = true;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(STRING)
    private Set<UserRole> roles;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles == null) {
            return Collections.singleton(new SimpleGrantedAuthority("UNCONFIRMED"));
        }
        return roles.stream().map(Enum::name).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
