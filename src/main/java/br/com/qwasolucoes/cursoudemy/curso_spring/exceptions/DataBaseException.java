package br.com.qwasolucoes.cursoudemy.curso_spring.exceptions;

public class DataBaseException extends RuntimeException {
    public DataBaseException(String message) {
        super(message);
    }
}
