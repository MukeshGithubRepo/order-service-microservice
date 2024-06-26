package com.rest.orderservice.service;


import com.rest.orderservice.dto.OrderDto;
import com.rest.orderservice.dto.OrderDtoFromFE;
import com.rest.orderservice.dto.User;
import com.rest.orderservice.entity.Order;
import com.rest.orderservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate   restTemplate;

    public Order addOrder(OrderDtoFromFE orderDtoFromFE) {

        Integer newOrderId=sequenceGenerator.generateNextOrderId();

        User user= fetchUserFromUserInfoMicroservice(orderDtoFromFE.getUserId());

        Order orderToBeSaved=new Order(newOrderId,orderDtoFromFE.getFoodItemlist(),orderDtoFromFE.getRestaurant(),user);

        orderRepo.save(orderToBeSaved);

        return orderToBeSaved;

    }

    private User fetchUserFromUserInfoMicroservice(Integer userId) {

       User fetchedUser= restTemplate.getForObject("http://USER-SERVICE/getuser/"+userId, User.class);
       return fetchedUser;

    }

}
