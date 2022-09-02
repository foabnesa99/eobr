package com.ftn.server.model.dto.korisnik;

import com.ftn.server.model.Korisnik;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KorisnikMapper {
    KorisnikMapper INSTANCE = Mappers.getMapper(KorisnikMapper.class);

    Korisnik fromCreateDto(KorisnikCreateRequest createRequest);
}
