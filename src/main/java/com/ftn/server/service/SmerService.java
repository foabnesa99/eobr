package com.ftn.server.service;

import com.ftn.server.model.dto.smer.SmerCreateRequest;
import com.ftn.server.model.dto.smer.SmerUpdateRequest;
import com.ftn.server.model.predmet.Smer;

public interface SmerService {
    Smer getById(Long id);

    Smer createSmer (SmerCreateRequest createRequest);

    Smer updateSmer(SmerUpdateRequest updateRequest);

    void removeSmer (Long id);
}
