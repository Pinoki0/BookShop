package com.example.BookShop.models;

public enum OrderStatus {
    O("open"),
    A("accepted"),
    C("cancelled"),
    CO("completed");

    public final String label;

    OrderStatus(String label) {
        this.label=label;
    }
}
