package com.rest.orderservice.controller;


import com.rest.orderservice.dto.OrderDto;
import com.rest.orderservice.dto.OrderDtoFromFE;
import com.rest.orderservice.entity.Order;
import com.rest.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveorder")
    public ResponseEntity<Order> saveOrder(@RequestBody OrderDtoFromFE orderDtoFromFE)
    {
        Order savedOrder=orderService.addOrder(orderDtoFromFE);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

}
