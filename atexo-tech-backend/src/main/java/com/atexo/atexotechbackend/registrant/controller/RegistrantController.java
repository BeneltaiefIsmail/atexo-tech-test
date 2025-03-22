package com.atexo.atexotechbackend.registrant.controller;

import com.atexo.atexotechbackend.registrant.service.RegistrantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/registants")
public class RegistrantController {


    private RegistrantService registrantService;

    public RegistrantController(RegistrantService registrantService) {
        this.registrantService = registrantService;
    }


}
