package com.electrocorhuila.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa {
    private Long id;
    private int estrato;
    private double valorKwh;
    private double subsidio;
}