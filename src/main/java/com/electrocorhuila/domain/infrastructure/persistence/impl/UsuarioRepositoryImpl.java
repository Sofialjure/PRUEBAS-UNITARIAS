package com.electrocorhuila.domain.infrastructure.persistence.impl;

import com.electrocorhuila.domain.infrastructure.persistence.Jpa.UsuarioJpaRepository;
import com.electrocorhuila.domain.infrastructure.persistence.entity.UsuarioEntity;
import com.electrocorhuila.domain.infrastructure.persistence.mapper.UsuarioMapper;
import com.electrocorhuila.domain.model.Usuario;
import com.electrocorhuila.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {
    
    private final UsuarioJpaRepository jpaRepository;
    
    @Override
    public List<Usuario> findAll() {
        return jpaRepository.findAll().stream()
                .map(UsuarioMapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<Usuario> findById(Long id) {
        return jpaRepository.findById(id)
                .map(UsuarioMapper::toDomain);
    }
    
    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        entity = jpaRepository.save(entity);
        return UsuarioMapper.toDomain(entity);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}