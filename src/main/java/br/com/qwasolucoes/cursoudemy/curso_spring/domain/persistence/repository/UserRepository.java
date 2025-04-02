package br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.repository;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
