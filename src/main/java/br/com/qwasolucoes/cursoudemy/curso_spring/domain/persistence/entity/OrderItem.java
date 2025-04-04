package br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.OrderItemDTO;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;

    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Double getSubTotal(){
        return this.price * this.quantity;
    }



    public OrderItem(OrderItemDTO order) {
        this.quantity = order.quantity();
        this.price = order.price();
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }
}
