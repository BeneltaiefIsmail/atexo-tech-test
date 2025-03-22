package com.atexo.atexotechbackend.registrant.service;

import com.atexo.atexotechbackend.registrant.dto.RegistrantDtoRequest;
import com.atexo.atexotechbackend.registrant.dto.RegistrantDtoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RegistrantService {

    RegistrantDtoResponse createRegistrant(RegistrantDtoRequest registrantDtoRequest);
    RegistrantDtoResponse updateRegistrantById(Long id, RegistrantDtoRequest registrantDtoRequest);
    Page<RegistrantDtoResponse> getAllRegistrants(Pageable pageable);
    RegistrantDtoResponse getRegistrantById(Long id);
    RegistrantDtoResponse deleteRegistrantById(Long id);
}
