package com.rest.orderservice.dto;

import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDtoFromFE {

    private List<FoodItem> foodItemlist;
    private Integer userId;
    private Restaurant restaurant;


    public List<FoodItem> getFoodItemlist() {
        return foodItemlist;
    }

    public void setFoodItemlist(List<FoodItem> foodItemlist) {
        this.foodItemlist = foodItemlist;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
