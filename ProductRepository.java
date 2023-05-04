package com.product.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.web.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
