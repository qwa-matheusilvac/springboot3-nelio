package br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.repository;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
