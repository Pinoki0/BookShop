package com.example.BookShop.models;

public enum BookGenre {
    CO("comedy"),
    AC("action"),
    SC("scifi"),
    HR("horror"),
    DR("Drama");

    public final String label;

    BookGenre(String label) {
        this.label=label;
    }
}
