package com.gimnasio.controller;

import com.gimnasio.model.Instructor;
import com.gimnasio.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Importante para DELETE
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructores") // ¡La nueva URL!
public class InstructorController {

    // Inyectamos al "Cerebro" (Service)
    @Autowired
    private InstructorService instructorService;

    // Endpoint para CREAR un nuevo instructor
    @PostMapping
    public Instructor crearInstructor(@RequestBody Instructor instructor) {
        return instructorService.guardarInstructor(instructor);
    }

    // Endpoint para LEER todos los instructores
    @GetMapping
    public List<Instructor> obtenerTodos() {
        return instructorService.obtenerTodosLosInstructores();
    }

    // --- NUEVOS ENDPOINTS ---

    // Endpoint para LEER un solo instructor por ID
    @GetMapping("/{id}")
    public Instructor obtenerInstructorPorId(@PathVariable Long id) {
        return instructorService.obtenerInstructorPorId(id);
    }

    // Endpoint para ACTUALIZAR un instructor
    @PutMapping("/{id}")
    public Instructor actualizarInstructor(@PathVariable Long id, @RequestBody Instructor detallesInstructor) {
        return instructorService.actualizarInstructor(id, detallesInstructor);
    }

    // Endpoint para BORRAR un instructor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInstructor(@PathVariable Long id) {
        instructorService.eliminarInstructor(id);
        // Devolvemos una respuesta 204 No Content (éxito sin cuerpo)
        return ResponseEntity.noContent().build();
    }
}