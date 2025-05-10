package com.electrocorhuila.domain.infrastructure.persistence.mapper;

import com.electrocorhuila.domain.infrastructure.persistence.entity.TarifaEntity;
import com.electrocorhuila.domain.model.Tarifa;

public class TarifaMapper {
    public static Tarifa toDomain(TarifaEntity entity) {
        return new Tarifa(
            entity.getId(),
            entity.getEstrato(),
            entity.getValorKwh(),
            entity.getSubsidio()
        );
    }
    
    public static TarifaEntity toEntity(Tarifa domain) {
        return new TarifaEntity(
            domain.getId(),
            domain.getEstrato(),
            domain.getValorKwh(),
            domain.getSubsidio()
        );
    }
}