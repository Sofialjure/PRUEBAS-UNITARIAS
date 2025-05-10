package com.electrocorhuila.domain.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.electrocorhuila.domain.application.service.TarifaService;
import com.electrocorhuila.domain.model.Tarifa;

import java.util.List;

@RestController
@RequestMapping("/api/tarifas")

public class TarifaController {
    private final TarifaService tarifaService;
    
    public TarifaController(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }
    
    @GetMapping
    public ResponseEntity<List<Tarifa>> getAllTarifas() {
        return new ResponseEntity<>(tarifaService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Tarifa> getTarifaById(@PathVariable Long id) {
        Tarifa tarifa = tarifaService.findById(id);
        return tarifa != null 
                ? new ResponseEntity<>(tarifa, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/estrato/{estrato}")
    public ResponseEntity<Tarifa> getTarifaByEstrato(@PathVariable int estrato) {
        Tarifa tarifa = tarifaService.findByEstrato(estrato);
        return tarifa != null
                ? new ResponseEntity<>(tarifa, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    public ResponseEntity<Tarifa> createTarifa(@RequestBody Tarifa tarifa) {
        return new ResponseEntity<>(tarifaService.save(tarifa), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Tarifa> updateTarifa(@PathVariable Long id, @RequestBody Tarifa tarifa) {
        tarifa.setId(id);
        Tarifa updatedTarifa = tarifaService.save(tarifa);
        return updatedTarifa != null
                ? new ResponseEntity<>(updatedTarifa, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarifa(@PathVariable Long id) {
        tarifaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
