package com.electrocorhuila.domain.infrastructure.persistence.impl;

import com.electrocorhuila.domain.application.service.TarifaService;
import com.electrocorhuila.domain.model.Tarifa;
import com.electrocorhuila.domain.repository.TarifaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TarifaServiceImpl implements TarifaService {

    private final TarifaRepository tarifaRepository;

    @Override
    public List<Tarifa> findAll() {
        return tarifaRepository.findAll();
    }

    @Override
    public Tarifa findById(Long id) {
        Optional<Tarifa> tarifa = tarifaRepository.findById(id);
        return tarifa.orElse(null);
    }

    @Override
    public Tarifa save(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    @Override
    public void deleteById(Long id) {
        tarifaRepository.deleteById(id);
    }

    @Override
    public Tarifa findByEstrato(int estrato) {
        Optional<Tarifa> tarifa = tarifaRepository.findByEstrato(estrato);
        return tarifa.orElse(null);
    }
}