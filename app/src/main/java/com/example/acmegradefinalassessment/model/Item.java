package com.example.acmegradefinalassessment.model;

public class Item {

    Integer id;
    private String name, desc;
    private int price, delivery;
    private Double rating;
    boolean addedToCart;

    public Item(Integer id, String name, String desc, int price, int delivery, Double rating) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.delivery = delivery;
        this.price = price;
        this.rating = rating;
        addedToCart = false;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrice() {
        return price;
    }

    public int getDelivery() {
        return delivery;
    }

    public Double getRating() {
        return rating;
    }

    public boolean isAddedToCart() {
        return addedToCart;
    }

    public void setAddedToCart(boolean addedToCart) {
        this.addedToCart = addedToCart;
    }

}
