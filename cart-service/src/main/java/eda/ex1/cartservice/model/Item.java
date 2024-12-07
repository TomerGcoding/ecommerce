package eda.ex1.cartservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Item implements Serializable {
    private static final Random random = new Random();
    private static final String ITEM_ID_PREFIX = "ITEM-";
    private static String ITEM_ID_SUFFIX = "001";
    private static final List<Integer> ITEM_QUANTITY = List.of(1, 2, 3, 4, 5);
    private static final List<Double> ITEM_PRICE = List.of(9.99,19.99,29.99,39.99,49.99,59.99);

    private String itemId;

    private Integer itemQuantity;

    private Double itemPrice;

    public Item() {
        this.itemId = ITEM_ID_PREFIX + ITEM_ID_SUFFIX;
        this.itemQuantity = ITEM_QUANTITY.get(random.nextInt(ITEM_QUANTITY.size()));
        this.itemPrice = ITEM_PRICE.get(random.nextInt(ITEM_PRICE.size()));
        ITEM_ID_SUFFIX = String.format("%03d", Integer.parseInt(ITEM_ID_SUFFIX) + 1);
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
