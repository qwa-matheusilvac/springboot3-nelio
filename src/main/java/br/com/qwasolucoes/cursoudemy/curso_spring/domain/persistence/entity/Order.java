package br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity;


import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.OrderReqDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private User client;

    public Order(OrderReqDTO orderReqDto) {
        this.moment = orderReqDto.moment();
        this.client= orderReqDto.client();
    }
}
