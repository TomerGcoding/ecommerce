package eda.ex1.orderservice.controller;

import eda.ex1.orderservice.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceController {

    @Autowired
    private OrdersRepository ordersRepository;


    @GetMapping("/order-details")
    public ResponseEntity<?> getOrderDetails(@RequestParam String orderId) {
        if(orderId == null) {
            return ResponseEntity.badRequest().body("Order Id is required");
        }
        if (ordersRepository.orderExists(orderId)) {
            return ResponseEntity.ok(ordersRepository.getOrder(orderId));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        }
    }
}