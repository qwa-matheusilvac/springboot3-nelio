package br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.pk;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Order;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class OrderItemPK {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
