package br.com.qwasolucoes.cursoudemy.curso_spring.web.controller;


import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.OrderReqDTO;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Order;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping
    public Page<Order> obterTodos(@PageableDefault(size = 10) Pageable page){
        return orderService.obterTodos(page);
    }

    @PostMapping
    public ResponseEntity<Order> criarNovo(@RequestBody OrderReqDTO orderReqDto, UriComponentsBuilder uriBuilder){
        Order order = orderService.criarNovo(orderReqDto);
        URI uri = uriBuilder.path("/books/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }

}
