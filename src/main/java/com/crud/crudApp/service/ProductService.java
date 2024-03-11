package com.crud.crudApp.service;

import com.crud.crudApp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;


    public Product saveProduct(Product p){
        repo.save(p);
        return p;
    }

    public List<Product> saveProducts(List<Product> p){
        return repo.saveAll(p);

    }

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id){
        return repo.findById(id).orElse(null);

    }

    public Product getProductByName(String name){
        return repo.findByName(name);

    }

    public  String deleteProduct(Product p){
        repo.delete(p);
        return "Product deleted";
    }
    public String deleteProductById(int id){
        repo.deleteById(id);
        return "Product with id " + id + " is deleted";
    }

    public Product updateProduct(Product p){
        Product cur = repo.findById(p.getId()).orElse(null);
        cur.setName(p.getName());
        cur.setPrice(p.getPrice());
        cur.setQuantity(p.getQuantity());

        return repo.save(cur);
    }

}
