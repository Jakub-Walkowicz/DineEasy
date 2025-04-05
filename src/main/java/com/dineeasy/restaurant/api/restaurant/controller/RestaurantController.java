package com.dineeasy.restaurant.api.restaurant.controller;


import com.dineeasy.restaurant.application.restaurant.RestaurantApplicationService;
import com.dineeasy.restaurant.application.restaurant.dto.RestaurantDTO;
import com.dineeasy.restaurant.application.restaurant.dto.RatingDTO;
import com.dineeasy.restaurant.application.restaurant.dto.ResponseRestaurantDTO;
import com.dineeasy.restaurant.application.restaurant.dto.UpdateRestaurantDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController()
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantApplicationService restaurantApplicationService;

    public RestaurantController(RestaurantApplicationService restaurantApplicationService) {
        this.restaurantApplicationService = restaurantApplicationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseRestaurantDTO createRestaurant(@RequestBody @Valid RestaurantDTO restaurantDTO){
        return restaurantApplicationService.createRestaurant(restaurantDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseRestaurantDTO updateRestaurant(@RequestBody @Valid UpdateRestaurantDTO updateRestaurantDTO, @PathVariable Long id){
        return restaurantApplicationService.updateRestaurant(id, updateRestaurantDTO);
    }

    @PatchMapping("/rate/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseRestaurantDTO rateRestaurant(@RequestBody @Valid RatingDTO ratingDTO, @PathVariable Long id){
        return restaurantApplicationService.rateRestaurant(id, ratingDTO);
    }
}
