package com.atexo.atexotechbackend.registration.service;

import com.atexo.atexotechbackend.common.exception.EntityNotFoundException;
import com.atexo.atexotechbackend.registration.dto.RegistrationDtoRequest;
import com.atexo.atexotechbackend.registration.dto.RegistrationDtoResponse;
import com.atexo.atexotechbackend.registration.entity.Registration;
import com.atexo.atexotechbackend.registration.repository.RegistrationRepository;
import com.atexo.atexotechbackend.registration.service.generetoruniquenumber.GeneratorUniqueInscritNumberService;
import com.atexo.atexotechbackend.registration.service.generetoruniquenumber.GeneratorUniqueNumberParam;
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
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final GeneratorUniqueInscritNumberService generatorUniqueInscritNumberService ;
    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository, GeneratorUniqueInscritNumberService generatorUniqueInscritNumberService) {
        this.registrationRepository = registrationRepository;
        this.generatorUniqueInscritNumberService = generatorUniqueInscritNumberService;
    }
    @Override
    @Transactional
    public RegistrationDtoResponse create (RegistrationDtoRequest registrationDtoRequest) {
        log.info("Starting Registrant creation process ");
        Registration newRegistration = RegistrationDtoRequest.toEntity(registrationDtoRequest);
        GeneratorUniqueNumberParam generatorUniqueNumberParam = new GeneratorUniqueNumberParam();
        generatorUniqueNumberParam.setFirstName(newRegistration.getFirstName());
        generatorUniqueNumberParam.setLastName(newRegistration.getLastName());
        generatorUniqueNumberParam.setDateOfBirth(newRegistration.getDateOfBirth());
        newRegistration.setUniqueIdentifier(generatorUniqueInscritNumberService.genrateUniqueInscritNumber(generatorUniqueNumberParam));
        registrationRepository.save(newRegistration);
        log.debug("User persisted with ID:  " , newRegistration.getId());
        return RegistrationDtoResponse.fromEntity(newRegistration);
    }

    @Override
    @Transactional
    public RegistrationDtoResponse update (Long id, RegistrationDtoRequest registrationDtoRequest) {
        Registration existingRegistration = registrationRepository.findById(id).
                orElseThrow(()-> new EntityNotFoundException("Registrant not found : " + id ));
        existingRegistration.setFirstName(registrationDtoRequest.getFirstName());
        existingRegistration.setLastName(registrationDtoRequest.getLastName());
        existingRegistration.setDateOfBirth(registrationDtoRequest.getBirthDate());
       // existingRegistration.setUniqueIdentifier(registrationDtoRequest.getUniqueIdentifier());
        registrationRepository.save(existingRegistration);
        return RegistrationDtoResponse.fromEntity(existingRegistration);
    }

    @Override
    public Page<RegistrationDtoResponse> findAll(Pageable pageable) {
        return registrationRepository.findAll(pageable).map(RegistrationDtoResponse::fromEntity);
    }

    @Override
    public RegistrationDtoResponse getById(Long id) {
        return registrationRepository.findById(id).map(RegistrationDtoResponse::fromEntity).
                orElseThrow(()-> new EntityNotFoundException("Registrant not found : " + id ));
    }

    @Override
    @Transactional
    public RegistrationDtoResponse deleteById(Long id) {
        Registration existingRegistration = registrationRepository.findById(id).
                orElseThrow(()-> new EntityNotFoundException("Registrant not found : " + id ));
        registrationRepository.delete(existingRegistration);
        return RegistrationDtoResponse.fromEntity(existingRegistration);
    }
}
