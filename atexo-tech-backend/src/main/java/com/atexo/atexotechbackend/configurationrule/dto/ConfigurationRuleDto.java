package com.atexo.atexotechbackend.configurationrule.dto;

import com.atexo.atexotechbackend.configurationrule.entity.CriteriaType;
import com.atexo.atexotechbackend.configurationrule.entity.ConfigurationRule;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfigurationRuleDto {

    private CriteriaType criteriaType;
    private Integer length;
    private String prefix;
    private String suffix;
    private String dateFormat;
    private Integer rank;
    private Integer initialValue;

    public static ConfigurationRule toEntity(ConfigurationRuleDto dto) {
        if (dto == null)
            return null;
        else {
            return ConfigurationRule.builder()
                    .criteriaType(dto.getCriteriaType())
                    .length(dto.getLength())
                    .prefix(dto.getPrefix())
                    .suffix(dto.getSuffix())
                    .dateFormat(dto.getDateFormat())
                    .rank(dto.getRank())
                    .initialValue(dto.getInitialValue())
                    .build();
        }
    }

}
