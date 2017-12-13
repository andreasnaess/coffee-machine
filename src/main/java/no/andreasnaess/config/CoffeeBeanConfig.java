package no.andreasnaess.config;

import no.andreasnaess.factory.CoffeeFactory;
import no.andreasnaess.factory.CoffeeFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoffeeBeanConfig {
    @Bean
    public CoffeeFactory coffeeFactory() {
        return new CoffeeFactoryImpl();
    }
}