package com.dineeasy.restaurant.application.restaurant;

import com.dineeasy.restaurant.application.restaurant.dto.*;
import com.dineeasy.restaurant.application.restaurant.mapper.RestaurantMapper;
import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
import com.dineeasy.restaurant.domain.restaurant.repository.RestaurantRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantApplicationService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantApplicationService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    public RestaurantResponseDTO createRestaurant(RestaurantCreateDTO restaurantCreateDTO){
        Restaurant entity = restaurantMapper.toEntity(restaurantCreateDTO);
        Restaurant saved = restaurantRepository.save(entity);
        return restaurantMapper.toDto(saved);
    }

    public void deleteRestaurant(Long restaurantId){
        try {
            restaurantRepository.deleteById(restaurantId);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalStateException("Restaurant with id: " + restaurantId + " does not exist!");
        }
    }

    public RestaurantResponseDTO updateRestaurant(Long restaurantId, RestaurantUpdateDTO restaurantUpdateDTO){
        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalStateException("Restaurant with id: " + restaurantId + " does not exist!"));
        restaurantMapper.updateEntityFromDto(restaurantUpdateDTO, existingRestaurant);
        Restaurant updatedRestaurant = restaurantRepository.save(existingRestaurant);
        return restaurantMapper.toDto(updatedRestaurant);
        }

    public RestaurantResponseDTO rateRestaurant(Long restaurantId, RatingDTO rating){
        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalStateException("Restaurant with id: " + restaurantId + " does not exist!"));
        double ratingDouble =  rating.getRating();
        existingRestaurant.calculateNewRating(ratingDouble);
        restaurantRepository.save(existingRestaurant);
        return restaurantMapper.toDto(existingRestaurant);
    }

    public RestaurantResponseDetailsDTO getRestaurantDetails(Long restaurantId){
        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalStateException("Restaurant with id: " + restaurantId + " does not exist!"));
        return restaurantMapper.toDetailsDto(existingRestaurant);
    }

    public List<RestaurantResponseDTO> getAllRestaurants(){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(restaurantMapper::toDto)
                .collect(Collectors.toList());
    }
}
