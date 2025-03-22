package com.atexo.atexotechbackend.settingcriteria.service;

import com.atexo.atexotechbackend.settingcriteria.dto.CriteriaConfigDtoRequest;
import com.atexo.atexotechbackend.settingcriteria.dto.CriteriaConfigDtoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CriteriaConfigService {

        CriteriaConfigDtoResponse createConfig(CriteriaConfigDtoRequest dtoRequest);
        CriteriaConfigDtoResponse getConfigById(Long id);
        Page<CriteriaConfigDtoResponse> getAllConfigs(Pageable pageable);
        CriteriaConfigDtoResponse updateConfig(Long id, CriteriaConfigDtoRequest dtoRequest);
        CriteriaConfigDtoResponse deleteConfig(Long id);
    }


