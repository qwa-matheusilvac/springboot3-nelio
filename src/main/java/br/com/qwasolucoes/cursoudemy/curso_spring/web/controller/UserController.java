package br.com.qwasolucoes.cursoudemy.curso_spring.web.controller;


import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.UserReqDto;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.User;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public Page<User> obterTodos(@PageableDefault(size = 10) Pageable page){
        return userService.obterTodos(page);
    }

    @PostMapping
    public ResponseEntity<User> criarNovo(@RequestBody UserReqDto userReqDto, UriComponentsBuilder uriBuilder){
        User user = new User(userReqDto);
        URI uri = uriBuilder.path("/books/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

}
