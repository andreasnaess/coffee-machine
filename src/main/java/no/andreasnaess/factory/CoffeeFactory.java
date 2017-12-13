package no.andreasnaess.factory;

import no.andreasnaess.dto.CoffeeRequest;
import no.andreasnaess.entities.Coffee;

public interface CoffeeFactory {
    Coffee createCoffee(CoffeeRequest request);
}