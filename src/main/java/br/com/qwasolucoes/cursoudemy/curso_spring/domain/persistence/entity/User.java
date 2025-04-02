package br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.UserReqDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String password;

    public User(UserReqDto userReqDto) {
        this.name = userReqDto.name();
        this.email = userReqDto.email();
        this.phone = userReqDto.phone();
        this.password = userReqDto.password();
    }
}
