package com.ftn.server.model.dto.nastavnik;

import com.ftn.server.model.NastavnikRole;
import com.ftn.server.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NastavnikCreateRequest {

    private String ime;

    private LocalDate datumRodjenja;

    private String korisnickoIme;

    private UserRole role;

    private NastavnikRole nastavnikRole;
}
