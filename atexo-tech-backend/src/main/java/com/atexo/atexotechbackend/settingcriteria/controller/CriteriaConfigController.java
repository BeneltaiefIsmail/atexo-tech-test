package com.atexo.atexotechbackend.settingcriteria.controller;

import com.atexo.atexotechbackend.settingcriteria.dto.CriteriaConfigDtoRequest;
import com.atexo.atexotechbackend.settingcriteria.dto.CriteriaConfigDtoResponse;
import com.atexo.atexotechbackend.settingcriteria.service.CriteriaConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/api/v1/CriteriaConfig")
public class CriteriaConfigController {

    private final CriteriaConfigService criteriaConfigService;

    @Autowired
    public CriteriaConfigController(CriteriaConfigService criteriaConfigService) {
        this.criteriaConfigService = criteriaConfigService;
    }

    @PostMapping
    public ResponseEntity<CriteriaConfigDtoResponse> createCriteriaConfig(
            @RequestBody CriteriaConfigDtoRequest dtoRequest) {

        log.info("POST Request: Create new criteria config");
        CriteriaConfigDtoResponse response = criteriaConfigService.createConfig(dtoRequest);
        return new ResponseEntity<>(response , HttpStatus.CREATED) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriteriaConfigDtoResponse> getCriteriaConfigById(
            @PathVariable Long id) {
        log.info("GET Request: Fetch criteria config with ID: " + id);
        return new ResponseEntity<>(criteriaConfigService.getConfigById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<CriteriaConfigDtoResponse>> getAllCriteriaConfigs(Pageable pageable) {
        log.info("GET Request: Searching All Criteria Config");
        return new ResponseEntity<>(criteriaConfigService.getAllConfigs(pageable), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriteriaConfigDtoResponse> updateCriteriaConfig(
            @PathVariable Long id,
            @RequestBody CriteriaConfigDtoRequest dtoRequest) {
        log.info("PUT Request: Update criteria config by ID: " + id);
        return ResponseEntity.ok(criteriaConfigService.updateConfig(id, dtoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCriteriaConfig(@PathVariable Long id) {
        log.info("DELETE Request: Delete criteria config with ID: " + id);
        criteriaConfigService.deleteConfig(id);
        return ResponseEntity.noContent().build();
    }
}
