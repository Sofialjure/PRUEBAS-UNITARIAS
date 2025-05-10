package com.electrocorhuila.domain.infrastructure.persistence.Jpa;

import com.electrocorhuila.domain.infrastructure.persistence.entity.TarifaEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaJpaRepository extends JpaRepository<TarifaEntity, Long> {
    Optional<TarifaEntity> findByEstrato(int estrato);
}