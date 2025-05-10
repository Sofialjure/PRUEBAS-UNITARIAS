package com.electrocorhuila.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String documento;
    private String email;
    private String telefono;
    private String direccion;
    private int estrato;
    private String numeroDocumento;

}

