package br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.UserReqDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String password;

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList();

    public User(UserReqDto userReqDto) {
        this.name = userReqDto.name();
        this.email = userReqDto.email();
        this.phone = userReqDto.phone();
        this.password = userReqDto.password();
    }
}
