package com.uts.edu.version1.controller.sets_controller;

import com.uts.edu.version1.entity.Sets;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/sets")
public class AbsoluteDifferenceController {
    @PostMapping("/absolute-difference")
    public String calculateAbsoluteDifference(@RequestBody Sets sets) {
        // Calcular la diferencia absoluta entre los conjuntos A y B
        String[] differenceArray = calculateAbsoluteDifference(sets.getA(), sets.getB());

        // Construir el mensaje de respuesta
        StringBuilder result = new StringBuilder();
        result.append("Conjunto A: ");
        appendArray(result, sets.getA());
        result.append("\n");

        result.append("Conjunto B: ");
        appendArray(result, sets.getB());
        result.append("\n");

        result.append("Diferencia absoluta de A con respecto a B: ");
        appendArray(result, differenceArray);

        return result.toString();
    }

    // Método para calcular la diferencia absoluta entre dos arrays de cadenas
    private String[] calculateAbsoluteDifference(String[] a, String[] b) {
        Set<String> setB = new HashSet<>(Arrays.asList(b));

        // Calcular los elementos que están en A pero no en B
        List<String> differenceList = new ArrayList<>();
        for (String element : a) {
            if (!setB.contains(element)) {
                differenceList.add(element);
            }
        }

        // Convertir la lista de diferencia a un array
        return differenceList.toArray(new String[0]);
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
