package com.atexo.atexotechbackend.registrant.controller;

import com.atexo.atexotechbackend.registrant.dto.RegistrantDtoRequest;
import com.atexo.atexotechbackend.registrant.dto.RegistrantDtoResponse;
import com.atexo.atexotechbackend.registrant.service.RegistrantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/registants")
public class RegistrantController {


    private RegistrantService registrantService;

    public RegistrantController(RegistrantService registrantService) {
        this.registrantService = registrantService;
    }

    @PostMapping
    public ResponseEntity<RegistrantDtoResponse> createRegistrant(
             @RequestBody RegistrantDtoRequest request) {
        return new ResponseEntity<>( registrantService.createRegistrant(request), HttpStatus.CREATED) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrantDtoResponse> getRegistrantById(
            @PathVariable Long id) {
        return new ResponseEntity<>(registrantService.getRegistrantById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<RegistrantDtoResponse>> getAllRegistrants(Pageable pageable) {
        return new ResponseEntity<>(registrantService.getAllRegistrants(pageable), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<RegistrantDtoResponse> deleteRegistrant(@PathVariable Long id) {
        return new ResponseEntity<>(registrantService.deleteRegistrantById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<RegistrantDtoResponse> updateRegistrant(@PathVariable Long id , @RequestBody RegistrantDtoRequest request) {
        return new ResponseEntity<>(registrantService.updateRegistrantById(id, request), HttpStatus.OK);
    }

}
