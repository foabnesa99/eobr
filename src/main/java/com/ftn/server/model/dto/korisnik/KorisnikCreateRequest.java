package com.ftn.server.model.dto.korisnik;

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
public class KorisnikCreateRequest {

    private String ime;

    private LocalDate datumRodjenja;

    private String korisnickoIme;

    private UserRole role;
}
