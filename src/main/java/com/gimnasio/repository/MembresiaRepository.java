package com.gimnasio.repository;

import com.gimnasio.model.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Long> {
    // Método extra para buscar todas las membresías de un usuario específico
    List<Membresia> findByUsuarioId(Long usuarioId);
}
