package eda.ex1.orderservice.mapper;

import eda.ex1.dtos.OrderDTO;
import eda.ex1.orderservice.model.Item;
import eda.ex1.orderservice.model.Order;

import java.util.List;
import java.util.stream.Collectors;

public class DTOMapper {

    public static Order mapOrderDTOToOrder(OrderDTO orderDTO) {
        List<Item> items = orderDTO.getItems().stream()
                .map(itemDTO -> new Item(itemDTO.getItemId(), itemDTO.getItemQuantity(), itemDTO.getItemPrice()))
                .collect(Collectors.toList());
        return new Order(orderDTO.getOrderId(), orderDTO.getCustomerId(), orderDTO.getOrderDate(), items, orderDTO.getTotalAmount(), orderDTO.getCurrency(), orderDTO.getOrderStatus());
    }
}
