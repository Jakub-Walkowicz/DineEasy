package com.dineeasy.restaurant.application.restaurant;

import com.dineeasy.restaurant.application.restaurant.dto.RestaurantDTO;
import com.dineeasy.restaurant.application.restaurant.dto.RatingDTO;
import com.dineeasy.restaurant.application.restaurant.dto.ResponseRestaurantDTO;
import com.dineeasy.restaurant.application.restaurant.dto.UpdateRestaurantDTO;
import com.dineeasy.restaurant.application.restaurant.mapper.RestaurantMapper;
import com.dineeasy.restaurant.domain.address.valueobject.Address;
import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
import com.dineeasy.restaurant.domain.restaurant.repository.RestaurantRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RestaurantApplicationService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantApplicationService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    public ResponseRestaurantDTO createRestaurant(RestaurantDTO restaurantDTO){
        Restaurant entity = restaurantMapper.toEntity(restaurantDTO);
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

    public ResponseRestaurantDTO updateRestaurant(Long restaurantId, UpdateRestaurantDTO updateRestaurantDTO){
        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalStateException("Restaurant with id: " + restaurantId + " does not exist!"));
        restaurantMapper.updateEntityFromDto(updateRestaurantDTO, existingRestaurant);
        Restaurant updatedRestaurant = restaurantRepository.save(existingRestaurant);
        return restaurantMapper.toDto(updatedRestaurant);
        }

    public ResponseRestaurantDTO rateRestaurant(Long restaurantId, RatingDTO rating){
        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalStateException("Restaurant with id: " + restaurantId + " does not exist!"));
        double ratingDouble =  rating.getRating();
        existingRestaurant.calculateNewRating(ratingDouble);
        restaurantRepository.save(existingRestaurant);
        return restaurantMapper.toDto(existingRestaurant);
    }
}
