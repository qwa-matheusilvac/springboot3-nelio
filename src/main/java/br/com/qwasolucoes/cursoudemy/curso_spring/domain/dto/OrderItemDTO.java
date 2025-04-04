package br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Order;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.OrderItem;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Product;

public record OrderItemDTO(Long orderId, Long productId, Integer quantity, Double price) {
    public static OrderItemDTO fromEntity(OrderItem orderItem) {
        return new OrderItemDTO(
                orderItem.getOrder().getId(),
                orderItem.getProduct().getId(),
                orderItem.getQuantity(),
                orderItem.getPrice()
        );
    }

    public OrderItem toEntity(Order order, Product product) {
        return new OrderItem(order, product, quantity, price);
    }
}
