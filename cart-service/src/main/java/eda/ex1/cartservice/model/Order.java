package eda.ex1.cartservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private static final String ORDER_ID_PREFIX = "ORD-";
    private static final String CUSTOMER_ID_PREFIX = "CUST-";
    private static String CUSTOMER_ID_SUFFIX = "00001";
    private static final List<String> CURRENCIES = List.of("USD", "EUR", "GBP", "ILS");
    private static final List<String> ORDER_STATUS = List.of("new", "pending", "confirmed", "shipped", "delivered");


    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("customerId")
    private String customerId;

    @JsonProperty("orderDate")
    private String orderDate;

    @JsonProperty("items")
    private List<Item> items;

    @JsonProperty("totalAmount")
    private Double totalAmount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("orderStatus")
    private String orderStatus;

    @JsonProperty("numOfItems")
    private Integer numOfItems;

    public Order(String orderId,Integer numOfItems) {
        if(!orderId.equals(ORDER_ID_PREFIX + String.format("%05d", Integer.parseInt(orderId.substring(4))))) {
            throw new IllegalArgumentException("Invalid input, orderId should be in the format ORD-XXXXX");
        }
        if (numOfItems < 1) {
            throw new IllegalArgumentException("Invalid input, numOfItems should be greater than 0");
        }
        this.orderId = orderId;
        this.numOfItems = numOfItems;
        this.customerId = CUSTOMER_ID_PREFIX + CUSTOMER_ID_SUFFIX;
        this.orderDate = java.time.LocalDate.now().toString();
        this.items = new ArrayList<>(numOfItems);
        for (int i = 0; i < numOfItems; i++) {
            items.add(new Item());
        }
        this.totalAmount = items.stream().mapToDouble(item -> item.getItemPrice() * item.getItemQuantity()).sum();
        this.currency = CURRENCIES.get((int) (Math.random() * CURRENCIES.size()));
        this.orderStatus = ORDER_STATUS.get((int) (Math.random() * ORDER_STATUS.size()));
        CUSTOMER_ID_SUFFIX = String.format("%05d", Integer.parseInt(CUSTOMER_ID_SUFFIX) + 1);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

}
