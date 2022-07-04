package com.example.ProductServiceApplication.repository;

import com.example.ProductServiceApplication.entity.DefaultProduct;
import com.example.ProductServiceApplication.repository.jpa.DefaultProductEntityJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DefaultProductRepositoryImpl implements DefaultProductRepository {

    private final DefaultProductEntityJpaRepository defaultProductEntityJpaRepository;

    @Override
    public List<DefaultProduct> findAll() {
        return defaultProductEntityJpaRepository.findAll().stream()
                .map(DefaultProduct::from)
                .collect(Collectors.toList());
    }
}