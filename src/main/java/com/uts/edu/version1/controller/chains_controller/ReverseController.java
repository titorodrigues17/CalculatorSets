package com.uts.edu.version1.controller.chains_controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strings")
public class ReverseController {


    public static class ReverseRequest {
        private String x;

        // Constructor vacío necesario para que Spring pueda convertir el JSON entrante a un objeto ReverseRequest
        public ReverseRequest() {}

        // Constructor con el campo 'x' para facilitar la creación de objetos ReverseRequest
        public ReverseRequest(String x) {
            this.x = x;
        }

        // Getters y Setters
        public String getX() {
            return x;
        }

        public void setX(String x) {
            this.x = x;
        }
    }

    @PostMapping("/reverse")
    public String reverseWord(@RequestBody ReverseRequest request) {
        String x = request.getX();

        // Invertir la palabra x
        StringBuilder reversedWord = new StringBuilder(x).reverse();

        return "La inversa de la palabra " + x + " es: " + reversedWord.toString();
    }
}
