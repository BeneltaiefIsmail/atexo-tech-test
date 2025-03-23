package com.atexo.atexotechbackend.registration.controller;

import com.atexo.atexotechbackend.registration.dto.RegistrationDtoRequest;
import com.atexo.atexotechbackend.registration.dto.RegistrationDtoResponse;
import com.atexo.atexotechbackend.registration.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Rest Controller For Entity Registrantion (inscrit)
 *  Expose EndPoints pour Opérations CRUD
 *  INFO : Pour le cas de test nosu avons besoin seulement de la méthode POST
 *  pour sauvegarder les données dans la base les autres méthode (GET/DELETE/GETALL/Update) => FOR purpose TEST
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/registants")
public class RegistrationController {


    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    /**
     * Create a new Registrant
     * @param registrationDtoRequest that contain the Registrant to Add
     * @return ResponseEntity with RegistrantDtoResponse with a status HTTP 201 (created)
     *  a new
     */
    @PostMapping
    public ResponseEntity<RegistrationDtoResponse> create  (@RequestBody RegistrationDtoRequest registrationDtoRequest) {
        log.info("Begining to create registrant");
        RegistrationDtoResponse response = registrationService.create(registrationDtoRequest);
        log.debug("Validate registraton : ", response.getId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDtoResponse> getById(
            @PathVariable Long id) {
        return new ResponseEntity<>(registrationService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<RegistrationDtoResponse>> findAll (Pageable pageable) {
        return new ResponseEntity<>(registrationService.findAll(pageable), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<RegistrationDtoResponse> delete (@PathVariable Long id) {
        return new ResponseEntity<>(registrationService.deleteById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<RegistrationDtoResponse> update (@PathVariable Long id , @RequestBody RegistrationDtoRequest request) {
        return new ResponseEntity<>(registrationService.update(id, request), HttpStatus.OK);
    }

}
