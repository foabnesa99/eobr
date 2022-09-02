package com.ftn.server.service;

import com.ftn.server.model.dto.predmet.PredmetCreateRequest;
import com.ftn.server.model.predmet.Predmet;

public interface PredmetService {

    Predmet getById(Long id);

    Predmet createPredmet(PredmetCreateRequest createRequest);

}
