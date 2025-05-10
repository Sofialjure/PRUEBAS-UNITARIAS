package com.electrocorhuila.domain.infrastructure.persistence.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import com.electrocorhuila.domain.infrastructure.persistence.Jpa.TarifaJpaRepository;
import com.electrocorhuila.domain.infrastructure.persistence.entity.TarifaEntity;
import com.electrocorhuila.domain.model.Tarifa;
import com.electrocorhuila.domain.repository.TarifaRepository;
import com.electrocorhuila.domain.infrastructure.persistence.mapper.TarifaMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class TarifaRepositoryImpl implements TarifaRepository {
    
    private final TarifaJpaRepository jpaRepository;
    
    @Override
    public List<Tarifa> findAll() {
        return jpaRepository.findAll().stream()
                .map(TarifaMapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<Tarifa> findById(Long id) {
        return jpaRepository.findById(id)
                .map(TarifaMapper::toDomain);
    }
    
    @Override
    public Tarifa save(Tarifa tarifa) {
        TarifaEntity entity = TarifaMapper.toEntity(tarifa);
        return TarifaMapper.toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    @Override
    public Optional<Tarifa> findByEstrato(int estrato) {
        return jpaRepository.findByEstrato(estrato)
                .map(TarifaMapper::toDomain);
    }
}