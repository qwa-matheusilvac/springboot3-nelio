package br.com.qwasolucoes.cursoudemy.curso_spring.domain.service;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.UserReqDto;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.User;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public Page<User> obterTodos(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public User criarNovo(UserReqDto userReqDto){
        return userRepository.save(new User(userReqDto));
    }

}
