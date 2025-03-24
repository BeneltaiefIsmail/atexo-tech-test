package com.atexo.atexotechbackend.configurationrule.repository;

import com.atexo.atexotechbackend.configurationrule.entity.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Long> {
}
