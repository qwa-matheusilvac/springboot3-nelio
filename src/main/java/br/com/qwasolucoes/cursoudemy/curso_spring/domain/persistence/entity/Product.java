package br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private String imgUrl;

    private Set<Category> categories = new HashSet<>();

    public Product(ProductDTO productDTO) {
        this.name = productDTO.name();
        this.description = productDTO.description();
        this.price = productDTO.price();
        this.imgUrl = productDTO.imgUrl();
        this.categories = productDTO.categories();
    }
}
