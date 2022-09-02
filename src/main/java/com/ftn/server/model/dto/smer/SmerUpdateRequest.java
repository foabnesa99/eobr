package com.ftn.server.model.dto.smer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SmerUpdateRequest {
    private LocalDate datumPocetkaStudija;

    private LocalDate datumKrajaStudija;
}
