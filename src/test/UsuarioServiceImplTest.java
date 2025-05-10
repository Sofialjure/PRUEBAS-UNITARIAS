package com.electrocorhuila.domain.application.service;

import com.electrocorhuila.domain.model.Usuario;
import com.electrocorhuila.domain.repository.UsuarioRepository;
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

public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        Usuario usuario1 = new Usuario(1L, "Juan", "Perez", "CC", "123", "juan@test.com", "123", "Calle 1", 2);
        Usuario usuario2 = new Usuario(2L, "Maria", "Gomez", "CC", "456", "maria@test.com", "456", "Calle 2", 3);
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario1, usuario2));

        // Act
        List<Usuario> result = usuarioService.findAll();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Juan", result.get(0).getNombre());
        assertEquals("Maria", result.get(1).getNombre());
    }

    @Test
    public void testFindById() {
        // Arrange
        Usuario usuario = new Usuario(1L, "Juan", "Perez", "CC", "123", "juan@test.com", "123", "Calle 1", 2);
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        // Act
        Usuario result = usuarioService.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
    }

    @Test
    public void testFindByIdNotFound() {
        // Arrange
        when(usuarioRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Usuario result = usuarioService.findById(1L);

        // Assert
        assertNull(result);
    }

    @Test
    public void testSave() {
        // Arrange
        Usuario usuarioToSave = new Usuario(null, "Juan", "Perez", "CC", "123", "juan@test.com", "123", "Calle 1", 2);
        Usuario savedUsuario = new Usuario(1L, "Juan", "Perez", "CC", "123", "juan@test.com", "123", "Calle 1", 2);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(savedUsuario);

        // Act
        Usuario result = usuarioService.save(usuarioToSave);

        // Assert
        assertNotNull(result.getId());
        assertEquals(1L, result.getId());
        assertEquals("Juan", result.getNombre());
    }

    @Test
    public void testDeleteById() {
        // Arrange
        doNothing().when(usuarioRepository).deleteById(1L);

        // Act
        usuarioService.deleteById(1L);

        // Assert
        verify(usuarioRepository, times(1)).deleteById(1L);
    }
}