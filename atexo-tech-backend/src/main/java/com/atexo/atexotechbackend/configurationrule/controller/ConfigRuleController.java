package com.atexo.atexotechbackend.configurationrule.controller;

import com.atexo.atexotechbackend.configurationrule.dto.ConfigRuleDtoResponse;
import com.atexo.atexotechbackend.configurationrule.dto.ConfigurationRuleDtoRequest;
import com.atexo.atexotechbackend.configurationrule.service.ConfigurationRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/api/v1/Configuration-Rules")
public class ConfigRuleController {

    private final ConfigurationRuleService configurationRuleService;

    @Autowired
    public ConfigRuleController(ConfigurationRuleService configurationRuleService) {
        this.configurationRuleService = configurationRuleService;
    }

    @PostMapping
    public ResponseEntity<Void> create(
            @RequestBody ConfigurationRuleDtoRequest dtoRequest) {
        log.info("POST Request: Create new criteria config");
        configurationRuleService.create(dtoRequest.getConfigurationRuleDtos());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfigRuleDtoResponse> getById(
            @PathVariable Long id) {
        log.info("GET Request: Fetch criteria config with ID: " + id);
        return new ResponseEntity<>(configurationRuleService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<ConfigRuleDtoResponse>> findAll(Pageable pageable) {
        log.info("GET Request: Searching All Criteria Config");
        return new ResponseEntity<>(configurationRuleService.findAll(pageable), HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ConfigRuleDtoResponse> update(
//            @PathVariable Long id,
//            @RequestBody ConfigurationRuleDto dtoRequest) {
//        log.info("PUT Request: Update criteria config by ID: " + id);
//        return ResponseEntity.ok(configRuleService.update(id, dtoRequest));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        log.info("DELETE Request: Delete criteria config with ID: " + id);
        configurationRuleService.deleteById(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
