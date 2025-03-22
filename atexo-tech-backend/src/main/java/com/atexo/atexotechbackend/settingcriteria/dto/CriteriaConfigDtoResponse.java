package com.atexo.atexotechbackend.settingcriteria.dto;

import com.atexo.atexotechbackend.settingcriteria.entity.Criteria;
import com.atexo.atexotechbackend.settingcriteria.entity.CriteriaConfig;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class CriteriaConfigDtoResponse {

    private Long id;
    private Criteria criteria;
    private Integer length;
    private String prefix;
    private String suffix;
    private String dateFormat;
    private Integer order;
    private Integer initialValue;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CriteriaConfigDtoResponse fromEntity(CriteriaConfig entity) {
        if (entity == null)
            return null;
        else {
            return CriteriaConfigDtoResponse.builder()
                    .id(entity.getId())
                    .criteria(entity.getCriteria())
                    .length(entity.getLength())
                    .prefix(entity.getPrefix())
                    .suffix(entity.getSuffix())
                    .dateFormat(entity.getDateFormat())
                    .order(entity.getPriorityOrder())
                    .initialValue(entity.getInitialValue())
                    .createdAt(entity.getCreatedAt())
                    .updatedAt(entity.getUpdatedAt())
                    .build();
        }
    }
}
