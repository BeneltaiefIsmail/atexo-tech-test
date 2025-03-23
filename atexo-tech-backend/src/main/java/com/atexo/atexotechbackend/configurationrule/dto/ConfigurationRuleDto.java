package com.atexo.atexotechbackend.configurationrule.dto;

import com.atexo.atexotechbackend.configurationrule.entity.CriteriaType;
import com.atexo.atexotechbackend.configurationrule.entity.ConfigurationRule;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfigurationRuleDto {
    @NotNull(message = "The criteria Type is mandatory")
    private CriteriaType criteriaType;
    @Positive(message = "the length must be positive")
    private Integer length;
    @Size(max = 5, message = "the prefixe length is less than {max}")
    private String prefix;
    @Size(max = 5, message = "the suffixe length is less than {max}")
    private String suffix;
    private String dateFormat;
    @Positive(message = "the rang must be positive")
    private Integer rank;
    @Min(value = 0, message = "the initial value must be positive")
    private Integer initialValue;
    public static ConfigurationRule toEntity(ConfigurationRuleDto dto) {
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
