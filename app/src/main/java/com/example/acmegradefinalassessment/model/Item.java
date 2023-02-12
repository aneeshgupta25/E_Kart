package com.example.acmegradefinalassessment.model;

public class Item {

    private String name, desc;
    private int price, delivery;
    private Double rating;

    public Item(String name, String desc, int price, int delivery, Double rating) {
        this.name = name;
        this.desc = desc;
        this.delivery = delivery;
        this.price = price;
        this.rating = rating;
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

}
