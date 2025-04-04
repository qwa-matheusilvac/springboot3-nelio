package br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.repository;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
