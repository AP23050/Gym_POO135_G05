package com.gimnasio.controller;

import com.gimnasio.model.Usuario;
import com.gimnasio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // ¡Importante para DELETE!
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para CREAR un nuevo usuario
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    // Endpoint para LEER todos los usuarios
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    // --- NUEVOS ENDPOINTS ---

    // Endpoint para LEER un solo usuario por ID
    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    // Endpoint para ACTUALIZAR un usuario
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario detallesUsuario) {
        return usuarioService.actualizarUsuario(id, detallesUsuario);
    }

    // Endpoint para BORRAR un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        // Devolvemos una respuesta 204 No Content (éxito sin cuerpo)
        return ResponseEntity.noContent().build();
    }
}