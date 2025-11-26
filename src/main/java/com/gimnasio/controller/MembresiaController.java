package com.gimnasio.controller;

import com.gimnasio.dto.MembresiaDTO;
import com.gimnasio.model.Membresia;
import com.gimnasio.service.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    // 1. Crear una Membresía (POST)
    // Recibimos el DTO (con el ID del usuario) y devolvemos la Membresía completa
    @PostMapping
    public ResponseEntity<Membresia> crear(@RequestBody MembresiaDTO membresiaDTO) {
        Membresia nueva = membresiaService.crearMembresia(membresiaDTO);
        return ResponseEntity.ok(nueva);
    }

    // 2. Listar todas las Membresías (GET)
    @GetMapping
    public List<Membresia> listar() {
        return membresiaService.obtenerTodas();
    }

    // 3. Eliminar una Membresía (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        membresiaService.eliminarMembresia(id);
        return ResponseEntity.noContent().build();
    }
}
