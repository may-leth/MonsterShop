package com.FemCoders.MonsterShop.repositories;

import com.FemCoders.MonsterShop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
