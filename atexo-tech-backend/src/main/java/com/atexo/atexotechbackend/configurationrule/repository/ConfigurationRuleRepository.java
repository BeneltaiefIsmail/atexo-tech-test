package com.atexo.atexotechbackend.configurationrule.repository;

import com.atexo.atexotechbackend.configurationrule.entity.ConfigurationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRuleRepository extends JpaRepository<ConfigurationRule, Long> {
}
