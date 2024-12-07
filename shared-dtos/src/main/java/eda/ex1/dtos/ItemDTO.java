package eda.ex1.dtos;

import java.io.Serializable;

public class ItemDTO implements Serializable {
    private String itemId;

    private Integer itemQuantity;

    private Double itemPrice;

    public ItemDTO(String itemId, Integer itemQuantity, Double itemPrice) {
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
