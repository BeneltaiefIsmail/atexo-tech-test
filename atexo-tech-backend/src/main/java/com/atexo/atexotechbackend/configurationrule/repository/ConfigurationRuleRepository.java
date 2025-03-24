package com.atexo.atexotechbackend.configurationrule.repository;

import com.atexo.atexotechbackend.configurationrule.entity.ConfigurationRule;
import com.atexo.atexotechbackend.configurationrule.entity.CriteriaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfigurationRuleRepository extends JpaRepository<ConfigurationRule, Long> {
    @Query("SELECT c FROM ConfigurationRule c ORDER BY c.rank ASC")
    List<ConfigurationRule> findAllByOrderByRankAsc();
    @Query("SELECT c FROM ConfigurationRule c WHERE c.criteriaType = :criteriaType")
    ConfigurationRule findByCriteriaType(@Param("criteriaType") CriteriaType criteriaType);
}
