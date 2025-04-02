package br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto;

public record UserReqDto(
        String name,
        String email,
        String phone,
        String password
) {
}

