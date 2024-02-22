package com.uts.edu.version1.controller;

import com.uts.edu.version1.entity.Sets;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/sets")
public class ComplementController {
    @PostMapping("/complement")
    public String calculateComplement(@RequestBody Sets sets) {
        // Calcular el complemento del conjunto B con respecto al conjunto A
        String[] complementArray = calculateComplement(sets.getA(), sets.getB());

        // Construir el mensaje de respuesta
        StringBuilder result = new StringBuilder();
        result.append("Conjunto Universal: ");
        appendArray(result, sets.getA());
        result.append("\n");

        result.append("Conjunto B: ");
        appendArray(result, sets.getB());
        result.append("\n");

        result.append("Complemento de B respecto al conjunto Universal: ");
        appendArray(result, complementArray);

        return result.toString();
    }

    // Método para calcular el complemento de un conjunto con respecto a otro conjunto universal
    private String[] calculateComplement(String[] universalSet, String[] b) {
        Set<String> setB = new HashSet<>(Arrays.asList(b));

        // Convertir el conjunto universal en un conjunto para facilitar la búsqueda
        Set<String> setUniversal = new HashSet<>(Arrays.asList(universalSet));

        // Calcular los elementos que están en el conjunto universal pero no en el conjunto B
        List<String> complementList = new ArrayList<>();
        for (String element : universalSet) {
            if (!setB.contains(element)) {
                complementList.add(element);
            }
        }

        // Convertir la lista de complemento a un array
        return complementList.toArray(new String[0]);
    }

    // Método para agregar un array a un StringBuilder
    private void appendArray(StringBuilder builder, String[] array) {
        builder.append("[");
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i < array.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
    }

}
