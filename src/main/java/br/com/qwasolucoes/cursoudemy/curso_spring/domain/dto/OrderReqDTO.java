package br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.enums.OrderStatus;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.User;

import java.time.Instant;

public record OrderReqDTO (
        Instant moment,
        User client,
        OrderStatus orderStatus
) {
}
