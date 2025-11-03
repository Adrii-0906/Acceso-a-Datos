package com.example.student_management.controllers;

import com.example.student_management.model.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private List<Alumno> alumnos  = new ArrayList<>(Arrays.asList(
        new Alumno(123, "Adrian Rana", "adrianr@gmail.com", 19, "2DAM"),
        new Alumno(456, "Oscar Fernandez", "oscarf@gmail.com", 19, "2DAM"),
        new Alumno(789, "Javier Carrillo", "javierc@gmail.com", 21, "1DAM"),
        new Alumno(234, "Jaime Bonilla", "jaimeb@gmail.com", 25, "2DAM")
    ));

    // GetMapping se usa para ver todos los datos de la clase Alumno
    @GetMapping
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    // GetMapping con un parametro, se usa para ver un Alumno, que tenga ese parametro
    @GetMapping("/{email}")
    public Alumno getAlumno(@PathVariable String email) {
        for (Alumno a : alumnos) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                return a;
            }
        }
        return null;
    }

    // PostMapping se usa para anandir un alumno a la lista
    @PostMapping
    public Alumno postAlumno(@RequestBody Alumno alumno) {
        alumnos.add(alumno);
        return alumno;
    }

    // PutMapping se usa para modificar los datos de un alumno
    @PutMapping
    public Alumno putAlumno(@RequestBody Alumno alumno) {
        for (Alumno a : alumnos) {
            if (a.getId() == alumno.getId()) {
                a.setNombre(alumno.getNombre());
                a.setEmail(alumno.getEmail());
                a.setEdad(alumno.getEdad());
                a.setCurso(alumno.getCurso());

                return a;
            }
        }
        return null;
    }

    // DeleteMapping se usa para eliminar un alumno en base a su id, pasando la id por parametro
    @DeleteMapping("/{id}")
    public Alumno deleteAlumno(@PathVariable int id) {
        for (Alumno a : alumnos) {
            if (a.getId() == id) {
                alumnos.remove(a);

                return a;
            }
        }
        return null;
    }

    // PatchMapping se usa para modificar parcialmente un Alumno
    @PatchMapping
    public Alumno patchAlumno(@RequestBody Alumno alumno) {
        for (Alumno a : alumnos) {
            if (a.getId() == alumno.getId()) {
                if (alumno.getNombre() != null) {
                    a.setNombre(alumno.getNombre());
                }
                if (alumno.getEmail() != null) {
                    a.setEmail(alumno.getEmail());
                }
                if (alumno.getEdad() > 0) {
                    a.setEdad(alumno.getEdad());
                }
                if (alumno.getCurso() != null) {
                    a.setCurso(alumno.getCurso());
                }

                return a;
            }
        }
        return null;
    }
}
