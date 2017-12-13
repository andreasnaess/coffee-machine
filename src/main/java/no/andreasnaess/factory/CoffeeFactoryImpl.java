package no.andreasnaess.factory;

import no.andreasnaess.dto.CoffeeRequest;
import no.andreasnaess.entities.Coffee;
import no.andreasnaess.entities.Size;
import no.andreasnaess.entities.Type;

public class CoffeeFactoryImpl implements CoffeeFactory {

    @Override
    public Coffee createCoffee(CoffeeRequest request) {
        Coffee coffee = new Coffee();
        coffee.setType(Type.valueOf(request.getType()));
        coffee.setSize(Size.valueOf(request.getSize()));

        setPrice(coffee);
        return coffee;
    }

    private void setPrice(Coffee coffee) {
        int price = coffee.getPrice();

        price += coffee.getType().getPrice();
        price += coffee.getSize().getPrice();

        coffee.setPrice(price);
    }
}