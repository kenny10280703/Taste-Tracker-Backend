package com.kenny.tastetracker.Repository;

import com.kenny.tastetracker.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
