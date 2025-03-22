package com.atexo.atexotechbackend.registrant.service;

import com.atexo.atexotechbackend.commun.exception.EntityNotFoundException;
import com.atexo.atexotechbackend.registrant.dto.RegistrantDtoRequest;
import com.atexo.atexotechbackend.registrant.dto.RegistrantDtoResponse;
import com.atexo.atexotechbackend.registrant.entity.Registrant;
import com.atexo.atexotechbackend.registrant.repository.RegistrantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementation for registrant CRUD operations.
 */
@Service
@Slf4j
public class RegistrantServiceImpl implements RegistrantService {

    RegistrantRepository registrantRepository;

    @Autowired
    public RegistrantServiceImpl(RegistrantRepository registrantRepository) {
        this.registrantRepository = registrantRepository;
    }

    @Override
    @Transactional
    public RegistrantDtoResponse createRegistrant(RegistrantDtoRequest registrantDtoRequest) {
        log.info("Starting Registrant creation process ");
        Registrant newRegistrant = RegistrantDtoRequest.toEntity(registrantDtoRequest);
        registrantRepository.save(newRegistrant);
        log.debug("User persisted with ID:  " , newRegistrant.getId());
        return RegistrantDtoResponse.fromEntity(newRegistrant);
    }

    @Override
    @Transactional
    public RegistrantDtoResponse updateRegistrantById(Long id, RegistrantDtoRequest registrantDtoRequest) {
        Registrant existingRegistrant = registrantRepository.findById(id).
                orElseThrow(()-> new EntityNotFoundException("Registrant not found : " + id ));
        existingRegistrant.setFirstName(registrantDtoRequest.getFirstName());
        existingRegistrant.setLastName(registrantDtoRequest.getLastName());
        existingRegistrant.setDateOfBirth(registrantDtoRequest.getBirthDate());
        registrantRepository.save(existingRegistrant);
        return RegistrantDtoResponse.fromEntity(existingRegistrant);
    }

    @Override
    public Page<RegistrantDtoResponse> getAllRegistrants(Pageable pageable) {
        return registrantRepository.findAll(pageable).map(RegistrantDtoResponse::fromEntity);
    }

    @Override
    public RegistrantDtoResponse getRegistrantById(Long id) {
        return registrantRepository.findById(id).map(RegistrantDtoResponse::fromEntity).
                orElseThrow(()-> new EntityNotFoundException("Registrant not found : " + id ));
    }

    @Override
    @Transactional
    public RegistrantDtoResponse deleteRegistrantById(Long id) {
        Registrant existingRegistrant = registrantRepository.findById(id).
                orElseThrow(()-> new EntityNotFoundException("Registrant not found : " + id ));
        registrantRepository.delete(existingRegistrant);
        return RegistrantDtoResponse.fromEntity(existingRegistrant);
    }
}
