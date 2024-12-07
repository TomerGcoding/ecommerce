package eda.ex1.orderservice.model;

public class Item {

    private String itemId;
    private Integer itemQuantity;
    private Double itemPrice;

    public Item(String itemId, Integer itemQuantity, Double itemPrice) {
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public Double getItemPrice() {
        return itemPrice;
    }
}
