package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    @GetMapping({"/saludo/{name}", "/hola/{name}"}) // Para llamar al endPoint por parametro seguimos del nombre con '/' y entre llaves ponemos el parametro
    public String greeting(@PathVariable String name) { // Con @PathVariable hacemos que parametro lo podamos llamar desde el @getMapping
        return "Hola " + name;
    }

}
