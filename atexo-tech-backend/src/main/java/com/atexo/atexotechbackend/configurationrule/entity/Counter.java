package com.atexo.atexotechbackend.configurationrule.entity;

import com.atexo.atexotechbackend.common.entity.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Counter implements Serializable {

    @Id
    private final Long id  = 1L;
    private Integer currentCounterValue;
}
