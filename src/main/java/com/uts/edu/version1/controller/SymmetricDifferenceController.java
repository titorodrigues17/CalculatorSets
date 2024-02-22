package com.uts.edu.version1.controller;

import com.uts.edu.version1.entity.Sets;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/sets")
public class SymmetricDifferenceController {

    @PostMapping("/symmetric-difference")
    public String calculateSymmetricDifference(@RequestBody Sets sets) {
        // Calcular la diferencia simétrica entre los conjuntos A y B
        String[] symmetricDifferenceArray = calculateSymmetricDifference(sets.getA(), sets.getB());

        // Construir el mensaje de respuesta
        StringBuilder result = new StringBuilder();
        result.append("Conjunto A: ");
        appendArray(result, sets.getA());
        result.append("\n");

        result.append("Conjunto B: ");
        appendArray(result, sets.getB());
        result.append("\n");

        result.append("Diferencia simétrica entre A y B: ");
        appendArray(result, symmetricDifferenceArray);

        return result.toString();
    }

    // Método para calcular la diferencia simétrica entre dos conjuntos
    private String[] calculateSymmetricDifference(String[] a, String[] b) {
        // Calcular la diferencia absoluta de A con respecto a B
        String[] differenceAB = calculateAbsoluteDifference(a, b);

        // Calcular la diferencia absoluta de B con respecto a A
        String[] differenceBA = calculateAbsoluteDifference(b, a);

        // Combinar las diferencias para obtener la diferencia simétrica
        Set<String> symmetricDifferenceSet = new HashSet<>();
        symmetricDifferenceSet.addAll(Arrays.asList(differenceAB));
        symmetricDifferenceSet.addAll(Arrays.asList(differenceBA));

        // Convertir el conjunto de diferencia simétrica a un array
        return symmetricDifferenceSet.toArray(new String[0]);
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
