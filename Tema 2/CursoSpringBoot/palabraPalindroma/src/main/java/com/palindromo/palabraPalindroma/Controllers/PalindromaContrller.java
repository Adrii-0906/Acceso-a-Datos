package com.palindromo.palabraPalindroma.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para verificar palindromos
 */
@RestController
public class PalindromaContrller {

    /**
     * Endpint para verificar si una palabra es un palindromo
     * @param name La palabra a verificar
     * @return Te devuelve un mensaje indicando si la palabra es un palindromo o no
     */
    @GetMapping("/validar_palindroma/{name}")
    public String validarPalindroma(@PathVariable String name) {

        return validarPlindroma(name);
    }

    /**
     * Con Stringbuilder le damos la vuelta a la palabra y luego ahcemos la comprobDacion
     * @param name La palabra a verificar
     * @return Te devuelve un mensaje indicando si la palabra es un palindromo o no
     */
    private String validarPlindroma(String name) {
        StringBuilder sb = new StringBuilder(name);

        sb.reverse();
        String palabraInvertida = sb.toString();

        if (name.equals(palabraInvertida)) {
            return "La palabra " + name + " SI es palindroma";
        } else {
            return "La palabra " + name + " NO es palindroma";
        }
    }
}
