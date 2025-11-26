package com.gimnasio.service;

import com.gimnasio.model.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> obtenerTodos();
    Usuario guardar(Usuario usuario);


    Usuario obtenerUsuarioPorId(Long id); // Para buscar uno solo
    Usuario actualizarUsuario(Long id, Usuario detallesUsuario); // Para actualizar
    void eliminarUsuario(Long id); // Para borrar
}