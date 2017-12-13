package no.andreasnaess.entities;

public enum Size {
    SMALL(5), MEDIUM(10), LARGE(15);

    private int price;

    Size(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}