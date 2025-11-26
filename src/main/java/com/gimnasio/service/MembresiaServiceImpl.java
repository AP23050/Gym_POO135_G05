package com.gimnasio.service;

import com.gimnasio.dto.MembresiaDTO;
import com.gimnasio.exception.ResourceNotFoundException;
import com.gimnasio.model.Membresia;
import com.gimnasio.model.Usuario;
import com.gimnasio.repository.MembresiaRepository;
import com.gimnasio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MembresiaServiceImpl implements MembresiaService {

    @Autowired
    private MembresiaRepository membresiaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; // ¡Necesitamos esto para buscar al dueño!

    @Override
    public Membresia crearMembresia(MembresiaDTO membresiaDTO) {
        // 1. Buscar al Usuario por el ID que viene en el DTO
        Usuario usuario = usuarioRepository.findById(membresiaDTO.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + membresiaDTO.getUsuarioId()));

        // 2. Crear la Membresía y llenar los datos
        Membresia membresia = new Membresia();
        membresia.setTipo(membresiaDTO.getTipo());
        membresia.setCosto(membresiaDTO.getCosto());
        membresia.setFechaInicio(LocalDate.now()); // Empieza hoy
        membresia.setFechaFin(LocalDate.now().plusMonths(1)); // Dura 1 mes (ejemplo)
        membresia.setActiva(true);

        // 3. ¡LA MAGIA! Asignamos el usuario a la membresía (Relación)
        membresia.setUsuario(usuario);

        // 4. Guardar
        return membresiaRepository.save(membresia);
    }

    @Override
    public List<Membresia> obtenerTodas() {
        return membresiaRepository.findAll();
    }

    @Override
    public void eliminarMembresia(Long id) {
        membresiaRepository.deleteById(id);
    }
}
