package br.com.qwasolucoes.cursoudemy.curso_spring.domain.service;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.OrderReqDTO;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.UserReqDto;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.enums.OrderStatus;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Order;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.User;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.repository.OrderRepository;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;

    public Page<Order> obterTodos(Pageable pageable){
        return orderRepository.findAll(pageable);
    }

    public Order criarNovo(OrderReqDTO orderReqDto){
        Order order = new Order(orderReqDto);
        order.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        return orderRepository.save(order);
    }

}
