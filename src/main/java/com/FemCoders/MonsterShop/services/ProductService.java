package com.FemCoders.MonsterShop.services;

import com.FemCoders.MonsterShop.dtos.Product.ProductMapper;
import com.FemCoders.MonsterShop.dtos.Product.ProductRequest;
import com.FemCoders.MonsterShop.dtos.Product.ProductResponse;
import com.FemCoders.MonsterShop.models.Product;
import com.FemCoders.MonsterShop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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

    public Optional<ProductResponse> getProduct(Long id){
        Optional<Product> Product = productRepository.findById(id);
        return Product.map(product -> ProductMapper.entityToDto(product));
    }

    public ProductResponse updateProduct(Long id, ProductRequest updatedProduct){
         Product existing = productRepository.findById(id)
                 .orElseThrow(() -> new NoSuchElementException("Producto con ID " + id + " no encontrado"));
            existing.setName(updatedProduct.name());
            existing.setPrice(updatedProduct.price());
            existing.setImageUrl(updatedProduct.imageUrl());
            existing.setRating(updatedProduct.rating());
            existing.setReviewCount(updatedProduct.reviewCount());
            existing.setFeatured(updatedProduct.featured());

            Product saved = productRepository.save(existing);
            return ProductMapper.entityToDto(saved);
    }

    public boolean deleteProduct(long id){
        if (!productRepository.existsById(id)){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }
}
