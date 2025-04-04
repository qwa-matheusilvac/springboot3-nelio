package br.com.qwasolucoes.cursoudemy.curso_spring.domain.service;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.UserReqDto;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.User;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.repository.UserRepository;
import br.com.qwasolucoes.cursoudemy.curso_spring.exceptions.ResourceNotFound;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public Page<User> obterTodos(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public User obterPorID(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
    }

    public User criarNovo(UserReqDto userReqDto){
        return userRepository.save(new User(userReqDto));
    }

    public User atualizarUser(Long id, UserReqDto userReqDto){
        User user = userRepository.getReferenceById(id);
        user.setName(userReqDto.name());
        user.setEmail(userReqDto.email());
        user.setPhone(userReqDto.phone());
        return userRepository.save(user);
}

    public void deletar(Long id){
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User não encontrado com o ID:" + id);
        }
        userRepository.deleteById(id);
    }
}
