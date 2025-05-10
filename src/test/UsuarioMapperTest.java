package com.electrocorhuila.domain.infrastructure.persistence.mapper;

import com.electrocorhuila.domain.infrastructure.persistence.entity.UsuarioEntity;
import com.electrocorhuila.domain.model.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioMapperTest {

   @Test
    public void testToDomain() {
        // Crear un UsuarioEntity simulado
        UsuarioEntity entity = new UsuarioEntity(
            1L,
            "Juan",
            "Perez",
            "CC",
            "123456789",
            "jperez@example.com",
            "3001234567",
            "Calle 123",
            3
        );

        // Ejecutar el mapeo a dominio
        Usuario domain = UsuarioMapper.toDomain(entity);

        // Validar el resultado
        assertNotNull(domain);
        assertEquals(entity.getId(), domain.getId());
        assertEquals("Juan", domain.getNombre());
        assertEquals("Perez", domain.getApellido());
        assertEquals("CC", domain.getDocumento());
        assertEquals("123456789", domain.getNumeroDocumento());
        assertEquals("jperez@example.com", domain.getEmail());
        assertEquals("3001234567", domain.getTelefono());
        assertEquals("Calle 123", domain.getDireccion());
        assertEquals(3, domain.getEstrato());

        System.out.println("✅ testToDomain ejecutado correctamente");
    }

    @Test
    public void testToEntity() {
        Usuario domain = new Usuario(
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

        UsuarioEntity entity = UsuarioMapper.toEntity(domain);

        assertNotNull(entity);
        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getNombre(), entity.getNombre());
        assertEquals(domain.getApellido(), entity.getApellido());
        assertEquals(domain.getDocumento(), entity.getDocumento());
        assertEquals(domain.getEmail(), entity.getEmail());
        assertEquals(domain.getTelefono(), entity.getTelefono());
        assertEquals(domain.getDireccion(), entity.getDireccion());
        assertEquals(domain.getEstrato(), entity.getEstrato());
    }
}