# coffee-machine

Et simpelt REST-API utviklet vha. av Spring Boot.
Applikasjonen krever MAVEN 3.0+ og Java 8 for å kjøre.
Kjøres med følgende kommando:
    
    mvn spring-boot:run

REST API-et har ett endepunkt med følgende path "/coffee"

Eksempel request:

    POST http://localhost:8080/coffee HTTP/1.1
    Accept: application/json
    Content-Type: application/json
    
    {
        "type":"CAPPUCCINO",
        "size":"LARGE"
    }
