package com.atexo.atexotechbackend.configurationrule.repository;

import com.atexo.atexotechbackend.configurationrule.entity.ConfigurationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigurationRuleRepository extends JpaRepository<ConfigurationRule, Long> {

    @Query("SELECT c FROM ConfigurationRule c ORDER BY c.rank ASC")
    List<ConfigurationRule> findAllByOrderByRankAsc();
}
