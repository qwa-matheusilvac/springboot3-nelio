package br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.CategoryReqDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "categories")
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category(CategoryReqDTO categoryReqDTO) {
        this.name = categoryReqDTO.name();
    }

    public Category(String name) {
        this.name = name;
    }
}
