package com.electrocorhuila.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testUsuarioCreation() {
        Usuario usuario = new Usuario();
        assertNotNull(usuario);
    }

    @Test
    public void testUsuarioFields() {
        Usuario usuario = new Usuario(
            1L, 
            "Juan", 
            "Perez", 
            "CC", 
            "123456789", 
            "juan@example.com", 
            "3001234567", 
            "Calle 123", 
            3
        );

        assertEquals(1L, usuario.getId());
        assertEquals("Juan", usuario.getNombre());
        assertEquals("Perez", usuario.getApellido());
        assertEquals("CC", usuario.getDocumento());
        assertEquals("123456789", usuario.getEmail());
        assertEquals("juan@example.com", usuario.getEmail());
        assertEquals("3001234567", usuario.getTelefono());
        assertEquals("Calle 123", usuario.getDireccion());
        assertEquals(3, usuario.getEstrato());
    }

    @Test
    public void testUsuarioSetters() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setDocumento("CC");
        usuario.setEmail("123456789");
        usuario.setTelefono("3001234567");
        usuario.setDireccion("Calle 123");
        usuario.setEstrato(3);

        assertEquals(1L, usuario.getId());
        assertEquals("Juan", usuario.getNombre());
        assertEquals("Perez", usuario.getApellido());
        assertEquals("CC", usuario.getDocumento());
        assertEquals("123456789", usuario.getEmail());
        assertEquals("3001234567", usuario.getTelefono());
        assertEquals("Calle 123", usuario.getDireccion());
        assertEquals(3, usuario.getEstrato());
    }
}