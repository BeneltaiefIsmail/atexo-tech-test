package com.atexo.atexotechbackend.configurationrule.service;

import com.atexo.atexotechbackend.configurationrule.dto.ConfigurationRuleDto;
import com.atexo.atexotechbackend.configurationrule.dto.ConfigRuleDtoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ConfigurationRuleService {
        List<ConfigRuleDtoResponse> create(List<ConfigurationRuleDto> dtoRequest);
        ConfigRuleDtoResponse getById(Long id);
        Page<ConfigRuleDtoResponse> findAll(Pageable pageable);
        //ConfigRuleDtoResponse update(Long id, ConfigurationRuleDto dtoRequest);
        ConfigRuleDtoResponse deleteById(Long id);
    }


