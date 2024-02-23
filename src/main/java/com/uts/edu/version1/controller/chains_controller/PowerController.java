package com.uts.edu.version1.controller.chains_controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strings")
public class PowerController {

    public static class Power {
        private String x;
        private int n;

        public Power() {
        }

        public Power(String x, int n) {
            this.x = x;
            this.n = n;
        }

        public String getX() {
            return x;
        }

        public void setX(String x) {
            this.x = x;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }
    }
    @PostMapping("/power")
    public String powerOfWord(@RequestBody Power request) {
        String  x = request.getX();
        int  n = request.getN();

        // Calcular la potencia de la cadena x concatenándola n veces
        StringBuilder powerWord = new StringBuilder();
        for (int i = 0; i < n; i++) {
            powerWord.append(x);
        }

        return "La potencia de la cadena " + x + " elevada a la " + n + " es: " + powerWord.toString();
    }
}
