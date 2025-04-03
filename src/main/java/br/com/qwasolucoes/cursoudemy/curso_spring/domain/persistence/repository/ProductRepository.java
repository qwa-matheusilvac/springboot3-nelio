package br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.repository;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
