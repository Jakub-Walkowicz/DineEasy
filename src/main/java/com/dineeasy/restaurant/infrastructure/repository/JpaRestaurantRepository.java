package com.dineeasy.restaurant.infrastructure.repository;

import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
import com.dineeasy.restaurant.domain.restaurant.repository.RestaurantRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRestaurantRepository extends JpaRepository<Restaurant, Long>, RestaurantRepository {
}
