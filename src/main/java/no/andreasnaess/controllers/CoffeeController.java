package no.andreasnaess.controllers;

import no.andreasnaess.dto.CoffeeRequest;
import no.andreasnaess.dto.CoffeeResponse;
import no.andreasnaess.entities.Coffee;

import no.andreasnaess.entities.Size;
import no.andreasnaess.entities.Type;
import no.andreasnaess.exceptions.BadRequestException;
import no.andreasnaess.factory.CoffeeFactory;
import no.andreasnaess.util.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoffeeController implements RequestValidator<CoffeeRequest> {

    @Autowired
    private CoffeeFactory coffeeFactory;

    @RequestMapping(value = "/coffee", method = RequestMethod.POST)
    public ResponseEntity<CoffeeResponse> createCoffee(@RequestBody() CoffeeRequest request) {
        validate(request);

        Coffee coffee = coffeeFactory.createCoffee(request);

        CoffeeResponse response = new CoffeeResponse();
        response.setType(coffee.getType().name());
        response.setSize(coffee.getSize().name());
        response.setPrice(String.valueOf(coffee.getPrice()));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public void validate(CoffeeRequest request) {
        try {
            Type.valueOf(request.getType());
        } catch (Exception e) {
            throw new BadRequestException("Validation error. The only valid types are: ESPRESSO, CAPPUCCINO, AMERICANO, REGULAR");
        }

        try {
            Size.valueOf(request.getSize());
        } catch (Exception e) {
            throw new BadRequestException("Validation error. The only valid sizes are: SMALL, MEDIUM, LARGE");
        }
    }
}