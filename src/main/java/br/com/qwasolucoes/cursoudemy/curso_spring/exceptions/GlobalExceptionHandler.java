package br.com.qwasolucoes.cursoudemy.curso_spring.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFound e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(httpStatus).body(new StandardError(error, Instant.now(), httpStatus.value(), error, e.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(httpStatus).body(new StandardError(error, Instant.now(), httpStatus.value(), error, e.getMessage(), request.getRequestURI()));
    }
}
