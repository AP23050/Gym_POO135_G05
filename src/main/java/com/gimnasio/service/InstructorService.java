package com.gimnasio.service;

import com.gimnasio.model.Instructor;
import java.util.List;

public interface InstructorService {

    // Define los métodos que el "cerebro" debe saber hacer
    Instructor guardarInstructor(Instructor instructor);
    List<Instructor> obtenerTodosLosInstructores();

    // --- NUEVOS MÉTODOS ---
    Instructor obtenerInstructorPorId(Long id); // Para buscar uno solo
    Instructor actualizarInstructor(Long id, Instructor detallesInstructor); // Para actualizar
    void eliminarInstructor(Long id); // Para borrar
}