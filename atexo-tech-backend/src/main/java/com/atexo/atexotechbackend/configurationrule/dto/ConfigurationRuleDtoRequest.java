package com.atexo.atexotechbackend.configurationrule.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ConfigurationRuleDtoRequest {

    private List<ConfigurationRuleDto> configurationRuleDtos;
}
