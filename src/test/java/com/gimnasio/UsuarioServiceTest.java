package com.gimnasio;

import com.gimnasio.model.Usuario;
import com.gimnasio.repository.UsuarioRepository;
import com.gimnasio.service.UsuarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository; // Simulamos la base de datos

    @InjectMocks
    private UsuarioServiceImpl usuarioService; // Probamos el servicio

    @Test
    public void guardarUsuario_DeberiaRetornarUsuarioGuardado() {
        // 1. PREPARAR (Arrange)
        Usuario usuarioParaGuardar = new Usuario();
        usuarioParaGuardar.setNombre("Test User");
        usuarioParaGuardar.setEmail("test@gimnasio.com");

        Usuario usuarioGuardado = new Usuario();
        usuarioGuardado.setId(1L);
        usuarioGuardado.setNombre("Test User");
        usuarioGuardado.setEmail("test@gimnasio.com");

        // Le decimos al simulacro: "Cuando te pidan guardar algo, devuelve este usuario con ID 1"
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioGuardado);

        // 2. ACTUAR (Act)
        Usuario resultado = usuarioService.guardar(usuarioParaGuardar);

        // 3. VERIFICAR (Assert)
        assertNotNull(resultado); // Que no sea nulo
        assertEquals(1L, resultado.getId()); // Que tenga el ID 1
        assertEquals("Test User", resultado.getNombre()); // Que el nombre sea correcto
    }
}
