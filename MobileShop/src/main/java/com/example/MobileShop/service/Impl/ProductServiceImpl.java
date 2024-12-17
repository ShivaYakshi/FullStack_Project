package com.example.MobileShop.service.Impl;

import com.example.MobileShop.model.product;
import com.example.MobileShop.repository.ProductRepository;
import com.example.MobileShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<product> getProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public product addProduct(product product) {
        return productRepository.save(product);
    }

    @Override
    public product updateProduct(String id, product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<product> findProductsByBrand(String brand) {
        // Filter products by brand using a stream
        return productRepository.findAll().stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @Override
    public List<product> findProductsInStock(boolean inStock) {
        // Filter products by stock status using a stream
        return productRepository.findAll().stream()
                .filter(product -> product.isInStock() == inStock)
                .collect(Collectors.toList());
    }
}
