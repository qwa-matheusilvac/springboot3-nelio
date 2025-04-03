package br.com.qwasolucoes.cursoudemy.curso_spring.web.controller;


import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.ProductDTO;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Product;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public Page<Product> obterTodos(@PageableDefault(size = 10) Pageable page){
        return productService.obterTodos(page);
    }

    @PostMapping
    public ResponseEntity<Product> criarNovo(@RequestBody ProductDTO productDTO, UriComponentsBuilder uriBuilder){
        Product product = productService.criarNovo(productDTO);
        URI uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(product);
    }

}
