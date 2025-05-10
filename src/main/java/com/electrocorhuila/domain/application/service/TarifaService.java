package com.electrocorhuila.domain.application.service;

import com.electrocorhuila.domain.model.Tarifa;
import java.util.List;

public interface TarifaService {
    List<Tarifa> findAll();
    Tarifa findById(Long id);
    Tarifa save(Tarifa tarifa);
    void deleteById(Long id);
    Tarifa findByEstrato(int estrato);
}