package eda.ex1.orderservice.model;

import java.util.List;

public class Order {
    private String orderId;
    private String customerId;
    private String orderDate;
    private List<Item> items;
    private Double totalAmount;
    private String currency;
    private String orderStatus;
    private Integer numOfItems;
    private Double shippingCost;

    public Order(String orderId,
                 String customerId,
                 String orderDate,
                 List<Item> items,
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
        this.shippingCost = 0.02 * totalAmount;
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

    public List<Item> getItems() {
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

    public Double getShippingCost() {
        return shippingCost;
    }
}
