package com.atexo.atexotechbackend.configurationrule.service;

import com.atexo.atexotechbackend.common.exception.EntityNotFoundException;
import com.atexo.atexotechbackend.configurationrule.dto.ConfigurationRuleDto;
import com.atexo.atexotechbackend.configurationrule.dto.ConfigRuleDtoResponse;
import com.atexo.atexotechbackend.configurationrule.entity.ConfigurationRule;
import com.atexo.atexotechbackend.configurationrule.repository.ConfigurationRuleRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Service implementation for Criteria Rules CRUD operations.
 */
@Slf4j
@Service
public class ConfigurationRuleServiceImpl implements ConfigurationRuleService {

    private final ConfigurationRuleRepository configurationRuleRepository;
    @Autowired
    public ConfigurationRuleServiceImpl(ConfigurationRuleRepository configurationRuleRepository) {
        this.configurationRuleRepository = configurationRuleRepository;
    }
    @Override
    @Transactional
    public void create(List<ConfigurationRuleDto> dtoRequest) {
        log.debug("Creating new criteria config");
        // delete the previous configuration ifExist
        configurationRuleRepository.deleteAll();
        // converting  the configRules
        List<ConfigurationRule> configurationRules = dtoRequest.stream()
                .map(ConfigurationRuleDto::toEntity)
                .collect(Collectors.toList());
        // 3. Save All (new config)
        configurationRuleRepository.saveAll(configurationRules);
    }
    @Override
    public ConfigRuleDtoResponse getById(Long id) {
        log.debug("searching criteriaConfig with id:  " + id);
        return configurationRuleRepository.findById(id)
                .map(ConfigRuleDtoResponse::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("CriteriaConfig not found : " + id ));
    }
    @Override
    public Page<ConfigRuleDtoResponse> findAll (Pageable pageable) {
        log.debug("seraching all criteria configs with page");
        Page<ConfigurationRule> configPage = configurationRuleRepository.findAll(pageable);
        return configPage.map(ConfigRuleDtoResponse::fromEntity);
    }
    @Override
    @Transactional
    public ConfigRuleDtoResponse update (Long id, ConfigurationRuleDto dtoRequest) {
        log.debug("update criteria config with ID: " + id);
        ConfigurationRule existingConfig = configurationRuleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Criteria Config not found: " + id));
        updateEntityFromDto(dtoRequest, existingConfig);
        ConfigurationRule updatedConfig = configurationRuleRepository.save(existingConfig);
        log.debug(" updated criteria config ID: " + id);
        return ConfigRuleDtoResponse.fromEntity(updatedConfig);
    }
    @Override
    @Transactional
    public ConfigRuleDtoResponse deleteById(Long id) {
        log.info("Delete criteriaconfig with id: " + id);
        ConfigurationRule configurationRule = configurationRuleRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Criteria Config not found : " + id ));
        configurationRuleRepository.delete(configurationRule);
        return ConfigRuleDtoResponse.fromEntity(configurationRule);
    }
    /**
     *
     * @param dto CriteriaConfigDtoRequest qui contient l'entité a modifier
     * @param entity => lentité a persiter a avec JPARepository  pour la mise a jours
     * @return modifie l'entité directement
     */
    private ConfigurationRule updateEntityFromDto(ConfigurationRuleDto dto, ConfigurationRule entity) {
        entity.setCriteriaType(dto.getCriteriaType());
        entity.setLength(dto.getLength());
        entity.setPrefix(dto.getPrefix());
        entity.setSuffix(dto.getSuffix());
        entity.setDateFormat(dto.getDateFormat());
        entity.setRank(dto.getRank());
        entity.setInitialValue(dto.getInitialValue());
        return entity;
    }
}
