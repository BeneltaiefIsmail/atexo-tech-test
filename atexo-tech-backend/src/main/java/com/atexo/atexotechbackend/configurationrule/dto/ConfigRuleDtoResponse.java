package com.atexo.atexotechbackend.configurationrule.dto;

import com.atexo.atexotechbackend.configurationrule.entity.CriteriaType;
import com.atexo.atexotechbackend.configurationrule.entity.ConfigurationRule;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class ConfigRuleDtoResponse {
    private Long id;
    private CriteriaType criteriaType;
    private Integer length;
    private String prefix;
    private String suffix;
    private String dateFormat;
    private Integer rank;
    private Integer initialValue;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public static ConfigRuleDtoResponse fromEntity(ConfigurationRule entity) {
        if (entity == null)
            return null;
        else {
            return ConfigRuleDtoResponse.builder()
                    .id(entity.getId())
                    .criteriaType(entity.getCriteriaType())
                    .length(entity.getLength())
                    .prefix(entity.getPrefix())
                    .suffix(entity.getSuffix())
                    .dateFormat(entity.getDateFormat())
                    .rank(entity.getRank())
                    .initialValue(entity.getInitialValue())
                    .createdAt(entity.getCreatedAt())
                    .updatedAt(entity.getUpdatedAt())
                    .build();
        }
    }
}
