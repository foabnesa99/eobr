package com.ftn.server.model.dto.smer;

import com.ftn.server.model.predmet.Smer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SmerMapper {

    SmerMapper INSTANCE = Mappers.getMapper(SmerMapper.class);

    Smer fromCreateDto(SmerCreateRequest smerCreateRequest);
}
