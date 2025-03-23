package com.atexo.atexotechbackend.configurationrule.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ConfigurationRuleDtoRequest {
    @NotEmpty(message = " The list of ConfigurationRule must be not null")
    @Valid
    private List<ConfigurationRuleDto> configurationRuleDtos;
}
