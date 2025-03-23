package com.atexo.atexotechbackend.configurationrule.entity;

import com.atexo.atexotechbackend.common.entity.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfigurationRule extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private CriteriaType criteriaType;
    private Integer length ;
    private String prefix ;
    private String suffix ;
    private String dateFormat ;
    private Integer rank;
    private Integer initialValue ;
}
