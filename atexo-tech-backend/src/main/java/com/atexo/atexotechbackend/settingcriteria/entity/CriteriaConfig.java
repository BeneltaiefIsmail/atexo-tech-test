package com.atexo.atexotechbackend.settingcriteria.entity;

import com.atexo.atexotechbackend.commun.entity.AbstractEntity;
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
public class CriteriaConfig extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private Criteria criteria ;
    private Integer length ;
    private String prefix ;
    private String suffix ;
    private String dateFormat ;
    private Integer priorityOrder ;
    private Integer initialValue ;

}
