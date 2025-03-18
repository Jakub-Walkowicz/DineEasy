package com.dineeasy.restaurant.api;

import com.dineeasy.restaurant.domain.entity.Restaurant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    public HttpResponse createRestaurant(Restaurant restaurant){

    }
}
