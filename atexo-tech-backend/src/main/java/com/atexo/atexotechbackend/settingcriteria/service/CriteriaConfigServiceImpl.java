package com.atexo.atexotechbackend.settingcriteria.service;

import com.atexo.atexotechbackend.commun.exception.EntityNotFoundException;
import com.atexo.atexotechbackend.settingcriteria.dto.CriteriaConfigDtoRequest;
import com.atexo.atexotechbackend.settingcriteria.dto.CriteriaConfigDtoResponse;
import com.atexo.atexotechbackend.settingcriteria.entity.CriteriaConfig;
import com.atexo.atexotechbackend.settingcriteria.repository.CriteriaConfigRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CriteriaConfigServiceImpl implements CriteriaConfigService {

    private final CriteriaConfigRepository criteriaConfigRepository;


    @Autowired
    public CriteriaConfigServiceImpl(CriteriaConfigRepository criteriaConfigRepository, CriteriaConfigService criteriaConfigService) {
        this.criteriaConfigRepository = criteriaConfigRepository;

    }


    @Override
    @Transactional
    public CriteriaConfigDtoResponse createConfig(CriteriaConfigDtoRequest dtoRequest) {
        log.debug("Creating new criteria config");
        CriteriaConfig newConfig = CriteriaConfigDtoRequest.toEntity(dtoRequest);
        CriteriaConfig savedConfig = criteriaConfigRepository.save(newConfig);
        return CriteriaConfigDtoResponse.fromEntity(savedConfig);
    }

    @Override
    public CriteriaConfigDtoResponse getConfigById(Long id) {
        log.debug("searching criteriaConfig with id:  " + id);
        return criteriaConfigRepository.findById(id)
                .map(CriteriaConfigDtoResponse::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("CriteriaConfig not found : " + id ));
    }

    @Override
    public Page<CriteriaConfigDtoResponse> getAllConfigs(Pageable pageable) {
        log.debug("seraching all criteria configs with page");
        Page<CriteriaConfig> configPage = criteriaConfigRepository.findAll(pageable);
        return configPage.map(CriteriaConfigDtoResponse::fromEntity);
    }

    @Override
    @Transactional
    public CriteriaConfigDtoResponse updateConfig(Long id, CriteriaConfigDtoRequest dtoRequest) {
        log.debug("update criteria config with ID: " + id);
        CriteriaConfig existingConfig = criteriaConfigRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Criteria Config not found: " + id));
        updateEntityFromDto(dtoRequest, existingConfig);
        CriteriaConfig updatedConfig = criteriaConfigRepository.save(existingConfig);
        log.debug(" updated criteria config ID: " + id);
        return CriteriaConfigDtoResponse.fromEntity(updatedConfig);
    }

    @Override
    @Transactional
    public CriteriaConfigDtoResponse deleteConfig(Long id) {
        log.info("Delete criteriaconfig with id: " + id);
        CriteriaConfig criteriaConfig = criteriaConfigRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Criteria Config not found : " + id ));
        criteriaConfigRepository.delete(criteriaConfig);
        return CriteriaConfigDtoResponse.fromEntity(criteriaConfig);

    }

    /**
     *
     * @param dto CriteriaConfigDtoRequest qui contient l'entité a modifier
     * @param entity => lentité a persiter a avec JPARepository  pour la mise a jours
     * @return modifie l'entité directement
     */
    private CriteriaConfig updateEntityFromDto(CriteriaConfigDtoRequest dto, CriteriaConfig entity) {
        entity.setCriteria(dto.getCriteria());
        entity.setLength(dto.getLength());
        entity.setPrefix(dto.getPrefix());
        entity.setSuffix(dto.getSuffix());
        entity.setDateFormat(dto.getDateFormat());
        entity.setOrder(dto.getOrder());
        entity.setInitialValue(dto.getInitialValue());
        return entity;
    }

}
