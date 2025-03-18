package com.dineeasy.restaurant.domain.service;


import com.dineeasy.restaurant.domain.repository.IRestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    private final IRestaurantRepository restaurantRepository;

    public RestaurantService(IRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


}
