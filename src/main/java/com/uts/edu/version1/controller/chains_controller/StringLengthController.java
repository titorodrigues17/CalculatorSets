package com.uts.edu.version1.controller.chains_controller;

import com.uts.edu.version1.entity.Chains;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strings")
public class StringLengthController {

    @PostMapping("/length")
    public String calculateStringLength(@RequestBody Chains request) {
        String[] a = request.getA();
        String[] b = request.getB();

        int lengthA = calculateLengthWithoutCommas(a);
        int lengthB = calculateLengthWithoutCommas(b);
        int totalLength = lengthA + lengthB;

        return "Longitud de la cadena A: " + lengthA + "\n" +
                "Longitud de la cadena B: " + lengthB + "\n" +
                "Longitud total de la suma de las cadenas A y B: " + totalLength;
    }

    private int calculateLengthWithoutCommas(String[] strings) {
        int totalLength = 0;
        for (String str : strings) {
            // Remover las comas de la cadena antes de calcular su longitud
            String stringWithoutCommas = str.replaceAll(",", "");
            totalLength += stringWithoutCommas.length();
        }
        return totalLength;
    }
}
