package com.ciklum.ciklumhybristesttask.service.impl;

import com.ciklum.ciklumhybristesttask.domain.Product;
import com.ciklum.ciklumhybristesttask.dto.OrderedProductDto;
import com.ciklum.ciklumhybristesttask.dto.ProductDto;
import com.ciklum.ciklumhybristesttask.repo.ProductRepository;
import com.ciklum.ciklumhybristesttask.service.ProductService;
import com.ciklum.ciklumhybristesttask.service.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import java.util.List;

@Service
@Validated
@Transactional
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;
    private ProductMapper productMapper;
    @Value("${remove.password.product}")
    private String password;


    @Autowired
    public ProductServiceImpl(final ProductRepository productRepository, final ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto findById(int id) {
        return productMapper.entityToDto(productRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Product with such id doen't exist")));
    }

    @Override
    public ProductDto findByName(final String name) {
        return productMapper.entityToDto(productRepository.findByName(name));
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @Override
    public ProductDto save(@Valid ProductDto productDto) {
        Product product = productRepository.save(productMapper.dtoToEntity(productDto));
        return productMapper.entityToDto(product);
    }

    @Override
    public List<ProductDto> findAll() {
       return productMapper.entitiesToDtoList(productRepository.findAll());
    }

    @Override
    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    @Override
    public List<OrderedProductDto> findOrderedProducts() {
        return productRepository.findOrderedProducts();
    }
}
