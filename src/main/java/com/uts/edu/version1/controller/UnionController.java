package com.uts.edu.version1.controller;

import com.uts.edu.version1.entity.Sets;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/sets")
public class UnionController {
    @PostMapping("/union")
    public String createSets(@RequestBody Sets sets) {
        // Calcular la unión de los conjuntos A y B
        String[] unionArray = union(sets.getA(), sets.getB());  //En el array unionArray se almacena la union de los conjuntos A y B

        // Construir el mensaje de respuesta
        StringBuilder result = new StringBuilder();  //Se crea un objeto de la clase StringBuilder, el cual permite crear cadenas de caracteres de manera eficiente
        result.append("Conjunto A: ");  //Se agrega el texto "Conjunto A: " al objeto result
        appendArray(result, sets.getA());  //Se agrega el contenido del array A al objeto result
        result.append("\n");  //Se agrega un salto de línea al objeto result

        result.append("Conjunto B: "); //Se agrega el texto "Conjunto B: " al objeto result
        appendArray(result, sets.getB());  //Se agrega el contenido del array B al objeto result
        result.append("\n");  //Se agrega un salto de línea al objeto result

        result.append("Unión de los conjuntos A y B: ");  //Se agrega el texto "Unión de los conjuntos A y B: " al objeto result
        appendArray(result, unionArray);  //Se agrega el contenido del array unionArray al objeto result
        return result.toString();  //Se retorna el contenido del objeto result como una cadena de caracteres
    }

    // Método para calcular la unión de dos arrays de cadenas
    private String[] union(String[] a, String[] b) {  //El método union recibe dos arrays de cadenas como parámetros
        Set<String> unionSet = new HashSet<>(); //Se crea un conjunto de cadenas llamado unionSet con el metodo hashSet, este conjunto no permite elementos duplicados

        // Agregar todos los elementos del array 'a' al conjunto de la unión
        for (String element : a) {  //Se recorre el array 'a' y se almacena cada elemento en la variable element
            unionSet.add(element);  //Se agrega el elemento al conjunto de la unión
        }

        // Agregar todos los elementos del array 'b' al conjunto de la unión
        for (String element : b) {  //Se recorre el array 'b' y se almacena cada elemento en la variable element
            unionSet.add(element);  //Se agrega el elemento al conjunto de la unión
        }

        // Convertir el conjunto de la unión de nuevo a un array
        return unionSet.toArray(new String[0]);  //Se convierte el conjunto de la unión a un array de cadenas y se retorna
    }


    private void appendArray(StringBuilder builder, String[] array) {  //El método appendArray recibe un objeto de la clase StringBuilder y un array de cadenas como parámetros
        builder.append("[");  //Se agrega el caracter "[" al objeto builder
        for (int i = 0; i < array.length; i++) {  //Se recorre el array de cadenas
            builder.append(array[i]);  //Se agrega el elemento actual al objeto builder
            if (i < array.length - 1) {  //Si el elemento actual no es el último del array se agrega una coma y un espacio al objeto builder
                builder.append(", "); //Se agrega una coma y un espacio al objeto builder
            }
        }
        builder.append("]");  //Se agrega el caracter "]" al objeto builder
    }


}



