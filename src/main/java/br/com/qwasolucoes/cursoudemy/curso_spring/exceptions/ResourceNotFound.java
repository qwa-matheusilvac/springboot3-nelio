package br.com.qwasolucoes.cursoudemy.curso_spring.exceptions;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(Object id) {
        super("Resource not found. ID " + id);
    }
}
