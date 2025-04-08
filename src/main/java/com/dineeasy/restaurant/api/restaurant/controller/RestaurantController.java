package com.dineeasy.restaurant.api.restaurant.controller;


import com.dineeasy.restaurant.application.restaurant.RestaurantApplicationService;
import com.dineeasy.restaurant.application.restaurant.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController()
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantApplicationService restaurantApplicationService;

    public RestaurantController(RestaurantApplicationService restaurantApplicationService) {
        this.restaurantApplicationService = restaurantApplicationService;
    }

    @PostMapping
    public RestaurantResponseDTO createRestaurant(@RequestBody @Valid RestaurantCreateDTO restaurantCreateDTO){
        return restaurantApplicationService.createRestaurant(restaurantCreateDTO);
    }

    @PutMapping("/{id}")
    public RestaurantResponseDTO updateRestaurant(@RequestBody @Valid RestaurantUpdateDTO restaurantUpdateDTO, @PathVariable Long id){
        return restaurantApplicationService.updateRestaurant(id, restaurantUpdateDTO);
    }

    @PatchMapping("/rate/{id}")
    public RestaurantResponseDTO rateRestaurant(@RequestBody @Valid RatingDTO ratingDTO, @PathVariable Long id){
        return restaurantApplicationService.rateRestaurant(id, ratingDTO);
    }

    @GetMapping("/{id}")
    public RestaurantResponseDetailsDTO getRestaurantDetails(@PathVariable Long id){
        return restaurantApplicationService.getRestaurantDetails(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id){
        try {
            restaurantApplicationService.deleteRestaurant(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping()
    public Collection<RestaurantResponseDTO> getAllRestaurants(){
        return restaurantApplicationService.getAllRestaurants();
    }

}
