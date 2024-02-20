package com.uts.edu.version1.controller;

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
public class InterceptionController {


    @PostMapping("/intercepcion")
    public String createSets(@RequestBody Sets sets) {
        // Calcular la intersección de los conjuntos A y B
        String[] intersectionArray = intersection(sets.getA(), sets.getB());  //En el array intersectionArray se almacena la intersección de los conjuntos A y B

        // Construir el mensaje de respuesta
        StringBuilder result = new StringBuilder();  //Se crea un objeto de la clase StringBuilder, el cual permite crear cadenas de caracteres de manera eficiente
        result.append("Conjunto A: ");
        appendArray(result, sets.getA());
        result.append("\n");

        result.append("Conjunto B: ");
        appendArray(result, sets.getB());
        result.append("\n");

        result.append("Intersección de los conjuntos A y B: ");
        appendArray(result, intersectionArray);
        return result.toString();
    }

    // Método para calcular la intersección de dos arrays de cadenas
    private String[] intersection(String[] a, String[] b) {
        Set<String> intersectionSet = new HashSet<>(); //Se crea un conjunto de cadenas llamado intersectionSet con el metodo hashSet, este conjunto no permite elementos duplicados

        // Convertir el array 'a' en un conjunto para facilitar la búsqueda
        Set<String> setA = new HashSet<>(Arrays.asList(a));  //Se convierte el array 'a' a un conjunto de cadenas llamado setA

        // Iterar sobre los elementos del array 'b' y agregar los que también estén en 'a'
        for (String element : b) {
            if (setA.contains(element)) {
                intersectionSet.add(element);
            }
        }

        // Convertir el conjunto de la intersección de nuevo a un array
        return intersectionSet.toArray(new String[0]);
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
