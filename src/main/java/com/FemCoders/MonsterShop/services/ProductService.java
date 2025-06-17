package com.FemCoders.MonsterShop.services;

import com.FemCoders.MonsterShop.models.Product;
import com.FemCoders.MonsterShop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product newProduct){
        return productRepository.save(newProduct);
    }

    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }

    public Optional<Product> updateProduct(Long id, Product updatedProduct){
        return productRepository.findById(id).map(existing -> {
            existing.setName(updatedProduct.getName());
            existing.setPrice(updatedProduct.getPrice());
            existing.setImageUrl(updatedProduct.getImageUrl());
            existing.setRating(updatedProduct.getRating());
            existing.setReviewCount(updatedProduct.getReviewCount());
            existing.setFeatured(updatedProduct.isFeatured());
            return productRepository.save(existing);
        });
    }

    public boolean deleteProduct(long id){
        if (!productRepository.existsById(id)){
            throw new RuntimeException("Producto no encontrado con el id: " + id);
        }
        productRepository.deleteById(id);
        return false;
    }

}
