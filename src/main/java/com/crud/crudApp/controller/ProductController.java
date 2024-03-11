package com.crud.crudApp.controller;

import com.crud.crudApp.entity.Product;
import com.crud.crudApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;


//    @PostMapping("/addProduct")
//    public String addProduct(){
//        return "hello";
//    }
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product p){
        return service.saveProduct(p);
    }

    @PostMapping(path = "/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> p){
        return service.saveProducts(p);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return service.getProducts();
    }
    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable int id){
        return  service.getProductById(id);
    }

    @GetMapping("/getProductByName/{name}")
    public Product getProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @PutMapping(path = "/updateProduct")
    public Product updateProduct(@RequestBody Product p){
        return service.updateProduct(p);
    }

    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestBody Product p){
        return service.deleteProduct(p);
    }

    @DeleteMapping("/deleteProductById")
    public String deleteProductById(@RequestBody int id){
        return service.deleteProductById(id);
    }



}
