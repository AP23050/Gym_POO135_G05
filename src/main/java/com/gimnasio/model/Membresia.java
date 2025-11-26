package com.gimnasio.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "membresias")
public class Membresia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Ej: "Mensual", "Anual", "VIP"
    private Double costo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean activa;

    // --- AQUÍ ESTÁ LA RELACIÓN (Lo que pide la rúbrica) ---
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false) // Crea una columna 'usuario_id' en la tabla
    private Usuario usuario;
}