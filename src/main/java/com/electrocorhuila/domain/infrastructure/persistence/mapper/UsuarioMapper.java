package com.electrocorhuila.domain.infrastructure.persistence.mapper;


import com.electrocorhuila.domain.infrastructure.persistence.entity.UsuarioEntity;
import com.electrocorhuila.domain.model.Usuario;

public class UsuarioMapper {
    public static Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
            entity.getId(),
            entity.getNombre(),
            entity.getApellido(),
            entity.getDocumento(),
            entity.getEmail(),
            entity.getTelefono(),
            entity.getDireccion(),
            entity.getEstrato(), null
        );
    }
    
    public static UsuarioEntity toEntity(Usuario domain) {
        return new UsuarioEntity(
            domain.getId(),
            domain.getNombre(),
            domain.getApellido(),
            domain.getDocumento(),
            domain.getEmail(),
            domain.getTelefono(),
            domain.getDireccion(),
            domain.getEstrato(), null
        );
    }
}