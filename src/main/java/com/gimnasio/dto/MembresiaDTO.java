package com.gimnasio.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MembresiaDTO {
    private String tipo;
    private Double costo;
    private Long usuarioId; // Solo pedimos el ID del usuario, no el objeto entero
}
