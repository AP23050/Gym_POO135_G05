package com.gimnasio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Este método se activa cuando no se encuentra algo (Usuario, Instructor, etc.)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> manejarRecursoNoEncontrado(ResourceNotFoundException ex, WebRequest request) {

        Map<String, Object> cuerpoRespuesta = new HashMap<>();
        cuerpoRespuesta.put("fecha", LocalDateTime.now());
        cuerpoRespuesta.put("mensaje", ex.getMessage()); // "Usuario no encontrado con ID..."
        cuerpoRespuesta.put("detalles", request.getDescription(false));
        cuerpoRespuesta.put("estado", "404 NOT_FOUND");

        return new ResponseEntity<>(cuerpoRespuesta, HttpStatus.NOT_FOUND);
    }

    // Aquí podrías agregar más manejadores para otros errores (ej. error 500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> manejarErrorGlobal(Exception ex, WebRequest request) {
        Map<String, Object> cuerpoRespuesta = new HashMap<>();
        cuerpoRespuesta.put("fecha", LocalDateTime.now());
        cuerpoRespuesta.put("mensaje", "Ocurrió un error interno en el servidor");
        cuerpoRespuesta.put("error_real", ex.getMessage());
        cuerpoRespuesta.put("estado", "500 INTERNAL_SERVER_ERROR");

        return new ResponseEntity<>(cuerpoRespuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
