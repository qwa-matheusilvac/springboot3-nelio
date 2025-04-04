package br.com.qwasolucoes.cursoudemy.curso_spring.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class StandardError extends RuntimeException {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(String message, Instant timestamp, Integer status, String error, String message1, String path) {
        super(message);
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message1;
        this.path = path;
    }
}
