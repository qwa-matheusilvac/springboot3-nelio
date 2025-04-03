package br.com.qwasolucoes.cursoudemy.curso_spring.domain.service;

import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.CategoryReqDTO;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.dto.ProductDTO;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Category;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.entity.Product;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.repository.CategoryRepository;
import br.com.qwasolucoes.cursoudemy.curso_spring.domain.persistence.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Page<Product> obterTodos(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    public Product criarNovo(ProductDTO productDTO){
        return productRepository.save(new Product(productDTO));
    }

}
