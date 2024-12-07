package eda.ex1.cartservice.mapper;

import eda.ex1.cartservice.model.Order;
import eda.ex1.dtos.ItemDTO;
import eda.ex1.dtos.OrderDTO;

import java.util.List;
import java.util.stream.Collectors;

public class DTOMapper {
    public static OrderDTO mapOrderToOrderDTO(Order order) {
        List<ItemDTO> itemDTOList = order.getItems().stream()
                .map(item -> new ItemDTO(item.getItemId(), item.getItemQuantity(), item.getItemPrice()))
                .collect(Collectors.toList());
        return new OrderDTO(order.getOrderId(), order.getCustomerId(), order.getOrderDate(), itemDTOList, order.getTotalAmount(), order.getCurrency(), order.getOrderStatus(), order.getNumOfItems());
    }

}
