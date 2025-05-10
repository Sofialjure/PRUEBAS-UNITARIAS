package com.electrocorhuila.domain.repository;

import com.electrocorhuila.domain.model.Tarifa;
import java.util.List;
import java.util.Optional;

public interface TarifaRepository {
    List<Tarifa> findAll();
    Optional<Tarifa> findById(Long id);
    Tarifa save(Tarifa tarifa);
    void deleteById(Long id);
    Optional<Tarifa> findByEstrato(int estrato);
}