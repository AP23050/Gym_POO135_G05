package com.gimnasio.service;

import com.gimnasio.exception.ResourceNotFoundException; // ¡Importante!
import com.gimnasio.model.Usuario;
import com.gimnasio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Tus métodos existentes
    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // --- NUEVOS MÉTODOS IMPLEMENTADOS ---

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        // Buscamos al usuario por ID. Si no lo encuentra, lanza un error.
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario detallesUsuario) {
        // 1. Buscamos al usuario que queremos actualizar
        Usuario usuario = obtenerUsuarioPorId(id);

        // 2. Actualizamos los campos
        usuario.setNombre(detallesUsuario.getNombre());
        usuario.setEmail(detallesUsuario.getEmail());
        usuario.setTelefono(detallesUsuario.getTelefono());
        usuario.setDireccion(detallesUsuario.getDireccion());

        // 3. Guardamos los cambios
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        // 1. Buscamos al usuario
        Usuario usuario = obtenerUsuarioPorId(id);
        // 2. Lo borramos
        usuarioRepository.delete(usuario);
    }
}
