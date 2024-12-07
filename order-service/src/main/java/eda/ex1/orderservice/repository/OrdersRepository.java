package eda.ex1.orderservice.repository;

import eda.ex1.orderservice.model.Order;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrdersRepository {

    private final ConcurrentHashMap<String, Order> orders = new ConcurrentHashMap<>();

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public void updateOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public void deleteOrder(String orderId) {
        orders.remove(orderId);
    }

    public boolean orderExists(String orderId) {
        return orders.containsKey(orderId);
    }


}
