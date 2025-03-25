package com.dineeasy.restaurant.domain.restaurant.service;


import com.dineeasy.restaurant.api.restaurant.dto.UpdateRestaurantDTO;
import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
import com.dineeasy.restaurant.domain.restaurant.repository.RestaurantRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long restaurantId){
        try {
            restaurantRepository.deleteById(restaurantId);
        }
        catch(EmptyResultDataAccessException e){
            throw new IllegalStateException("Restaurant with id: " + restaurantId + " does not exist!");
        }
    }

    public void rateRestaurant(Long restaurantId, double rating){
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isEmpty()) {
            throw new IllegalStateException("Restaurant with id: " + restaurantId + " does not exist!");
        }
        Restaurant restaurant = restaurantOptional.get();
        restaurant.calculateNewRating(rating);
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(Long restaurantId, UpdateRestaurantDTO updateRestaurantDTO){
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isEmpty()) {
            throw new IllegalStateException("Restaurant with id: " + restaurantId + " does not exist!");
        }
        Restaurant restaurant = restaurantOptional.get();
        if (updateRestaurantDTO.getPhoneNumber() != null){
            restaurant.setPhoneNumber(updateRestaurantDTO.getPhoneNumber());
        }
        if (updateRestaurantDTO.getPhoneNumber() != null){
            restaurant.setPhoneNumber(updateRestaurantDTO.getPhoneNumber());
        }

        if (updateRestaurantDTO.getPhoneNumber() != null){
            restaurant.setPhoneNumber(updateRestaurantDTO.getPhoneNumber());
        }
    }
}
