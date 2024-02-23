package com.uts.edu.version1.controller.sets_controller;

import com.uts.edu.version1.entity.Sets;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/sets")
public class BelongingController {


    @PostMapping("/pertinence")
    public String checkPertinence(@RequestBody Sets sets) {
        // Verificar si todos los elementos de B están contenidos en A
        boolean isPertinent = checkPertinence(sets.getA(), sets.getB());

        // Construir el mensaje de respuesta
        StringBuilder result = new StringBuilder();
        result.append("Conjunto A: ");
        appendArray(result, sets.getA());
        result.append("\n");

        result.append("Conjunto B: ");
        appendArray(result, sets.getB());
        result.append("\n");

        if (isPertinent) {
            result.append("El conjunto B está contenido en el conjunto A");
        } else {
            result.append("El conjunto B NO está contenido en el conjunto A");
        }

        return result.toString();
    }

    // Método para verificar si todos los elementos de B están contenidos en A
    private boolean checkPertinence(String[] a, String[] b) {
        Set<String> setA = new HashSet<>(Arrays.asList(a));

        // Verificar si todos los elementos de B están contenidos en A
        for (String element : b) {
            if (!setA.contains(element)) {
                return false;
            }
        }
        return true;
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
