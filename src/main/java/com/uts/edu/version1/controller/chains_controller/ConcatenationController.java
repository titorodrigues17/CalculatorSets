package com.uts.edu.version1.controller.chains_controller;

import com.uts.edu.version1.entity.Chains;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strings")
public class ConcatenationController {
    @PostMapping("/concatenate")
    public String concatenateWords(@RequestBody Chains request) {
        String [] x = request.getA();
        String [] y = request.getB();

        // Concatenar los elementos de los arreglos x y y
        StringBuilder concatenatedWord = new StringBuilder();  // StringBuilder es una clase que permite manipular cadenas de caracteres de forma eficiente
        for (String word : x) {
            concatenatedWord.append(word);
        }
        for (String word : y) {
            concatenatedWord.append(word);
        }

        return "La concatenación de las palabras a y b es: " + concatenatedWord.toString();
    }
    }

