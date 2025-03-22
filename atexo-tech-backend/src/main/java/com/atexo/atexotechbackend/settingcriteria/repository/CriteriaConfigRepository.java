package com.atexo.atexotechbackend.settingcriteria.repository;

import com.atexo.atexotechbackend.settingcriteria.entity.CriteriaConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriaConfigRepository extends JpaRepository<CriteriaConfig, Long> {
}
