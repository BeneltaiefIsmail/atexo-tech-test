package com.atexo.atexotechbackend.registrant.service;

import com.atexo.atexotechbackend.registrant.dto.RegistrantDtoRequest;
import com.atexo.atexotechbackend.registrant.dto.RegistrantDtoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Collection;

public interface RegistrantService {

    RegistrantDtoResponse createSubscriber(RegistrantDtoRequest registrantDtoRequest);
    RegistrantDtoResponse updateSubscriberById(Long id, RegistrantDtoRequest registrantDtoRequest);
    Page<RegistrantDtoResponse> getAllSubscribers(Pageable pageable);
    RegistrantDtoResponse getSubscriberById(Long id);
    RegistrantDtoResponse deleteSubscriberById(Long id);
}
