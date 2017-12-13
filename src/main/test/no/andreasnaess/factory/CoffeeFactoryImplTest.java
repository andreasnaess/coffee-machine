package no.andreasnaess.factory;

import no.andreasnaess.config.CoffeeBeanConfig;
import no.andreasnaess.dto.CoffeeRequest;
import no.andreasnaess.entities.Coffee;
import no.andreasnaess.entities.Size;
import no.andreasnaess.entities.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CoffeeBeanConfig.class)
public class CoffeeFactoryImplTest {

    @Autowired
    CoffeeFactory coffeeFactory;

    @Test
    public void shouldCreateCoffeeWithPriceFromCoffeeRequest() {
        CoffeeRequest coffeeRequest = new CoffeeRequest();
        coffeeRequest.setType("CAPPUCCINO");
        coffeeRequest.setSize("LARGE");

        Coffee coffee = coffeeFactory.createCoffee(coffeeRequest);

        assertThat(coffee.getType(), is(Type.CAPPUCCINO));
        assertThat(coffee.getSize(), is(Size.LARGE));

        assertNotNull(coffee.getPrice());
    }
}