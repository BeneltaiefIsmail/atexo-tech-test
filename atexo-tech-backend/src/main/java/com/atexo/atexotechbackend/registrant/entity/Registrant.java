package com.atexo.atexotechbackend.registrant.entity;

import com.atexo.atexotechbackend.commun.entity.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "subscriber")
@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Registrant extends AbstractEntity {

    private String firstName ;
    private String lastName ;
    private LocalDate dateOfBirth ;
    private String uniqueIdentifier ;
}
