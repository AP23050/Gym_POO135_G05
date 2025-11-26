package com.gimnasio.service;

import com.gimnasio.dto.MembresiaDTO;
import com.gimnasio.model.Membresia;
import java.util.List;

public interface MembresiaService {
    // Método para crear una membresía recibiendo el DTO
    Membresia crearMembresia(MembresiaDTO membresiaDTO);

    // Método para listar todas
    List<Membresia> obtenerTodas();

    // Método para borrar
    void eliminarMembresia(Long id);
}
