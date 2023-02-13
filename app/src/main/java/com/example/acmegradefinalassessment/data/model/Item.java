package com.example.acmegradefinalassessment.data.model;

public class Item {

    Integer id;
    private String name, desc, url;
    private int price, delivery;
    private Double rating;
    boolean addedToCart;

    public Item(Integer id, String name, String desc, int price, int delivery, Double rating, String url) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.delivery = delivery;
        this.price = price;
        this.rating = rating;
        addedToCart = false;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public boolean isAddedToCart() {
        return addedToCart;
    }

    public void setAddedToCart(boolean addedToCart) {
        this.addedToCart = addedToCart;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
