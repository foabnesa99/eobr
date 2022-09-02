package com.ftn.server.service.impl;

import com.ftn.server.model.dto.smer.SmerCreateRequest;
import com.ftn.server.model.dto.smer.SmerMapper;
import com.ftn.server.model.dto.smer.SmerUpdateRequest;
import com.ftn.server.model.predmet.Smer;
import com.ftn.server.repository.SmerRepository;
import com.ftn.server.service.SmerService;
import com.ftn.server.util.exceptions.SmerMissingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SmerServiceImpl implements SmerService {

    private final SmerRepository smerRepository;

    @Override
    public Smer getById(Long id) {
        return smerRepository.findById(id).orElseThrow(SmerMissingException::new);
    }

    @Override
    public Smer createSmer(SmerCreateRequest createRequest) {
        return smerRepository.save(SmerMapper.INSTANCE.fromCreateDto(createRequest));
    }

    @Override
    public Smer updateSmer(SmerUpdateRequest updateRequest) {
        return null;
    }

    @Override
    public void removeSmer(Long id) {
        smerRepository.delete(getById(id));
    }

}
