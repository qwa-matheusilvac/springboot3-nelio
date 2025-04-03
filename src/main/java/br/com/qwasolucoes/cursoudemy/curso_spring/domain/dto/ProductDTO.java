package br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Category;

import java.util.Set;

public record ProductDTO(
        String name,
        String description,
        Double price,
        String imgUrl,
        Set<Category> categories
) {
}
