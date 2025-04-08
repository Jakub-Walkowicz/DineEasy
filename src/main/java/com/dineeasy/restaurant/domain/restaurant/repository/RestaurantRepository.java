package com.dineeasy.restaurant.domain.restaurant.repository;

import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository{
    Restaurant save(Restaurant restaurant);
    Optional<Restaurant> findById(Long id);
    void deleteById(Long id);
    List<Restaurant> findAll();
}
