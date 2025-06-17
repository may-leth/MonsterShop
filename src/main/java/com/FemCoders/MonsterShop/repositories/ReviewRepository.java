package com.FemCoders.MonsterShop.repositories;

import com.FemCoders.MonsterShop.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
