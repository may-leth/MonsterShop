package com.FemCoders.MonsterShop.services;

import com.FemCoders.MonsterShop.dtos.ProductMapper;
import com.FemCoders.MonsterShop.dtos.ProductRequest;
import com.FemCoders.MonsterShop.dtos.ProductResponse;
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

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.entityToDto(product)).toList();
    }

    public ProductResponse addProduct(ProductRequest productRequest){
        Product newProduct = ProductMapper.dtoToEntity(productRequest);
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.entityToDto(savedProduct);
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
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

}
