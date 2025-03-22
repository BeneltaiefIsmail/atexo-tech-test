package com.atexo.atexotechbackend.registrant.repository;

import com.atexo.atexotechbackend.registrant.entity.Registrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrantRepository extends JpaRepository<Registrant, Long> {
}
