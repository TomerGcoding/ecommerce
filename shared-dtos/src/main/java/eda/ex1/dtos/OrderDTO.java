package eda.ex1.dtos;

import java.io.Serializable;
import java.util.List;


public class OrderDTO implements Serializable {
    private String orderId;

    private String customerId;

    private String orderDate;

    private List<ItemDTO> items;

    private Double totalAmount;

    private String currency;

    private String orderStatus;

    private Integer numOfItems;

    public OrderDTO() {
    }

    public OrderDTO(String orderId,
                    String customerId,
                    String orderDate,
                    List<ItemDTO> items,
                    Double totalAmount,
                    String currency,
                    String orderStatus,
                    Integer numOfItems) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.items = items;
        this.totalAmount = totalAmount;
        this.currency = currency;
        this.orderStatus = orderStatus;
        this.numOfItems = numOfItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public Integer getNumOfItems() {
        return numOfItems;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                ", currency='" + currency + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", numOfItems=" + numOfItems +
                '}';
    }
}
