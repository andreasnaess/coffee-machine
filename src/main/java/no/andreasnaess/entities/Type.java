package no.andreasnaess.entities;

public enum Type {
    ESPRESSO(20), CAPPUCCINO(25), AMERICANO(18), REGULAR(22);

    private int price;

    Type(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}