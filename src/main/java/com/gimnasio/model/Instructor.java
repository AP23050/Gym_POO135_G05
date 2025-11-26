package com.gimnasio.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "instructores")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;
    private String email;
}