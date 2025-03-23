package com.atexo.atexotechbackend.registration.service;

import com.atexo.atexotechbackend.registration.dto.RegistrationDtoRequest;
import com.atexo.atexotechbackend.registration.dto.RegistrationDtoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RegistrationService {

    RegistrationDtoResponse create (RegistrationDtoRequest registrationDtoRequest);
    RegistrationDtoResponse update (Long id, RegistrationDtoRequest registrationDtoRequest);
    Page<RegistrationDtoResponse> findAll(Pageable pageable);
    RegistrationDtoResponse getById(Long id);
    RegistrationDtoResponse deleteById(Long id);
}
