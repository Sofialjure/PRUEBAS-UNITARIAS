package com.electrocorhuila.domain.infrastructure.persistence.impl;

import com.electrocorhuila.domain.infrastructure.persistence.Jpa.UsuarioJpaRepository;
import com.electrocorhuila.domain.infrastructure.persistence.entity.UsuarioEntity;
import com.electrocorhuila.domain.infrastructure.persistence.mapper.UsuarioMapper;
import com.electrocorhuila.domain.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UsuarioRepositoryImplTest {

    @Mock
    private UsuarioJpaRepository jpaRepository;

    @InjectMocks
    private UsuarioRepositoryImpl usuarioRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        UsuarioEntity entity1 = new UsuarioEntity(1L, "Juan", "Perez", "CC", "123", "juan@test.com", "123", "Calle 1", 2);
        UsuarioEntity entity2 = new UsuarioEntity(2L, "Maria", "Gomez", "CC", "456", "maria@test.com", "456", "Calle 2", 3);
        when(jpaRepository.findAll()).thenReturn(Arrays.asList(entity1, entity2));

        // Act
        List<Usuario> result = usuarioRepository.findAll();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Juan", result.get(0).getNombre());
        assertEquals("Maria", result.get(1).getNombre());
    }

    @Test
    public void testFindById() {
        // Arrange
        UsuarioEntity entity = new UsuarioEntity(1L, "Juan", "Perez", "CC", "123", "juan@test.com", "123", "Calle 1", 2);
        when(jpaRepository.findById(1L)).thenReturn(Optional.of(entity));

        // Act
        Optional<Usuario> result = usuarioRepository.findById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Juan", result.get().getNombre());
    }

    @Test
    public void testSave() {
        // Arrange
        Usuario usuario = new Usuario(null, "Juan", "Perez", "CC", "123", "juan@test.com", "123", "Calle 1", 2);
        UsuarioEntity savedEntity = new UsuarioEntity(1L, "Juan", "Perez", "CC", "123", "juan@test.com", "123", "Calle 1", 2);
        when(jpaRepository.save(any(UsuarioEntity.class))).thenReturn(savedEntity);

        // Act
        Usuario result = usuarioRepository.save(usuario);

        // Assert
        assertNotNull(result.getId());
        assertEquals(1L, result.getId());
        assertEquals("Juan", result.getNombre());
    }

    @Test
    public void testDeleteById() {
        // Arrange
        doNothing().when(jpaRepository).deleteById(1L);

        // Act
        usuarioRepository.deleteById(1L);

        // Assert
        verify(jpaRepository, times(1)).deleteById(1L);
    }
}