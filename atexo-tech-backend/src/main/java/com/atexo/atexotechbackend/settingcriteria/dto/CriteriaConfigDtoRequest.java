package com.atexo.atexotechbackend.settingcriteria.dto;

import com.atexo.atexotechbackend.settingcriteria.entity.Criteria;
import com.atexo.atexotechbackend.settingcriteria.entity.CriteriaConfig;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CriteriaConfigDtoRequest {

    private Criteria criteria;
    private Integer length;
    private String prefix;
    private String suffix;
    private String dateFormat;
    private Integer order;
    private Integer initialValue;

    public static CriteriaConfig toEntity(CriteriaConfigDtoRequest dto) {
        if (dto == null)
            return null;
        else {
            return CriteriaConfig.builder()
                    .criteria(dto.getCriteria())
                    .length(dto.getLength())
                    .prefix(dto.getPrefix())
                    .suffix(dto.getSuffix())
                    .dateFormat(dto.getDateFormat())
                    .order(dto.getOrder())
                    .initialValue(dto.getInitialValue())
                    .build();
        }
    }

}
