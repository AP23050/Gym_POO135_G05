package com.gimnasio.service;

import com.gimnasio.exception.ResourceNotFoundException; // Importamos la excepción
import com.gimnasio.model.Instructor;
import com.gimnasio.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    // Inyectamos al "Bodeguero" (Repository)
    @Autowired
    private InstructorRepository instructorRepository;

    // Implementamos el método para guardar
    @Override
    public Instructor guardarInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    // Implementamos el método para obtener todos
    @Override
    public List<Instructor> obtenerTodosLosInstructores() {
        return instructorRepository.findAll();
    }

    // --- NUEVOS MÉTODOS IMPLEMENTADOS ---

    @Override
    public Instructor obtenerInstructorPorId(Long id) {
        // Buscamos al instructor por ID. Si no lo encuentra, lanza un error.
        return instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor no encontrado con ID: " + id));
    }

    @Override
    public Instructor actualizarInstructor(Long id, Instructor detallesInstructor) {
        // 1. Buscamos al instructor que queremos actualizar
        Instructor instructor = obtenerInstructorPorId(id);

        // 2. Actualizamos los campos
        instructor.setNombre(detallesInstructor.getNombre());
        instructor.setEspecialidad(detallesInstructor.getEspecialidad());
        instructor.setEmail(detallesInstructor.getEmail());

        // 3. Guardamos los cambios
        return instructorRepository.save(instructor);
    }

    @Override
    public void eliminarInstructor(Long id) {
        // 1. Buscamos al instructor
        Instructor instructor = obtenerInstructorPorId(id);
        // 2. Lo borramos
        instructorRepository.delete(instructor);
    }
}