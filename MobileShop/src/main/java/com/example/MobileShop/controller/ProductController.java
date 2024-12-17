package com.example.MobileShop.controller;

import com.example.MobileShop.model.product;
import com.example.MobileShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public List<product> getAllProducts() {
        return productService.getAllProducts();
    }

 
    @GetMapping("/{id}")
    public product getProductById(@PathVariable String id) {
        return productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

    @PostMapping
    public product addProduct(@RequestBody product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public product updateProduct(@PathVariable String id, @RequestBody product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return "Product deleted successfully with ID: " + id;
    }

    @GetMapping("/brand/{brand}")
    public List<product> getProductsByBrand(@PathVariable String brand) {
        return productService.findProductsByBrand(brand);
    }

    @GetMapping("/in-stock")
    public List<product> getProductsInStock() {
        return productService.findProductsInStock(true);
    }
}
