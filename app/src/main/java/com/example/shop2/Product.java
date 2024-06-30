package com.example.shop2;

public class Product {
    private String name;
    private int image;
    private double price;
    private int numSell;
    private String information;
    public Product(String name, int image, double price, String information) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.numSell = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumSell() {
        return numSell;
    }

    public void setNumSell(int numSell) {
        this.numSell = numSell;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
