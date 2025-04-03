package br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.repository;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
