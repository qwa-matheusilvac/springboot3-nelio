package br.com.qwasolucoes.cursoudemy.curso_spring.web.controller;


import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.CategoryReqDTO;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.UserReqDto;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Category;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.User;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.service.CategoryService;
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
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public Page<Category> obterTodos(@PageableDefault(size = 10) Pageable page){
        return categoryService.obterTodos(page);
    }

    @PostMapping
    public ResponseEntity<Category> criarNovo(@RequestBody CategoryReqDTO categoryReqDto, UriComponentsBuilder uriBuilder){
        Category category = categoryService.criarNovo(categoryReqDto);
        URI uri = uriBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(category);
    }

}
