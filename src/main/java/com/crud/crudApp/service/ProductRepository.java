package com.crud.crudApp.service;

import com.crud.crudApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    public Product findByName(String name);
}
