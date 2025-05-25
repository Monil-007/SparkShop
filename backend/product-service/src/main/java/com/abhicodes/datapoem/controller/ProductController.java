package com.abhicodes.datapoem.controller;

import com.abhicodes.datapoem.entity.Product;
import com.abhicodes.datapoem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService prodService;

    List<Product> temp;
    @GetMapping("/products")
    public List<Product> displayAll(){
        temp = prodService.displayAllProducts();
        if (!temp.isEmpty()) {
            System.out.println("First product: " + temp.get(0).toString());
        } else {
            System.out.println("No products found in the database");
        }
        return temp;
    }

    @PostMapping("/{id}")
    public Product listProduct(@PathVariable long id){
        System.out.println("Id: "+id);
        return prodService.listProduct(id);
    }
}
