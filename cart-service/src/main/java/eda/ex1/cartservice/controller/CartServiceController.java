package eda.ex1.cartservice.controller;

import eda.ex1.cartservice.mapper.DTOMapper;
import eda.ex1.cartservice.model.Order;
import eda.ex1.cartservice.publisher.OrderPublisher;
import eda.ex1.dtos.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartServiceController {

    @Autowired
    private final OrderPublisher orderPublisher;

    public CartServiceController(OrderPublisher orderPublisher) {
        this.orderPublisher = orderPublisher;
    }

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestParam String orderId, @RequestParam String itemsNum) {
        if(orderId == null || itemsNum == null) {
            return ResponseEntity.badRequest().body("Invalid input");
        }
        try{
            Integer numOfItems = Integer.parseInt(itemsNum);
            Order order = new Order(orderId, numOfItems);
            OrderDTO orderDTO = DTOMapper.mapOrderToOrderDTO(order);
            orderPublisher.publishOrder(orderDTO);
            return ResponseEntity.ok(order);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid input, itemsNum should be an integer");
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
