package com.FemCoders.MonsterShop.repositories;

import com.FemCoders.MonsterShop.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
