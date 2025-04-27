package com.SAD.linkthefight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/* 
 Tener el GlobalException es una alternativa para el control de errores, nos permite ahorrarnos utilizar try y catch (Puede que no sea la mejor practica pero funciona.)
 @ExceptionHandler nos sirve para decirle a @RestControllerAdvice los errores que queremos capturar, por ejemplo en este caso es "IllegalArgumentException".
 ResponseEntity Es la clase que Spring usa para devolver respuestas HTTP que nos permite devolver el body
 IllegalArgumentException Es una clase de excepción que lanza Java cuando se le pasa un argumento inválido a un método o función.
*/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    // Puedes seguir agregando más si lo necesitas
}
