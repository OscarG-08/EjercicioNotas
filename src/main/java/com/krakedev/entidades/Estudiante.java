/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.krakedev.entidades;

import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class Estudiante {

    private String nombre;
    private String apellido;
    private String cedula;
    private ArrayList<Nota> notas;

    public Estudiante(String nombre, String apellido, String cedula, ArrayList<Nota> notas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.notas = notas;
    }

    public Estudiante(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public void agregarNota(Nota nuevaNota) {
        for (int i = 0; i < notas.size(); i++) {
            Nota notaExistente = notas.get(i);
            if (notaExistente.getMateria().getCodigo().equals(nuevaNota.getMateria().getCodigo())) {
                System.out.println("No se puede agregar la nota. Ya existe una nota para la materia con código " + nuevaNota.getMateria().getCodigo());
                return;
            }
        }

        if (nuevaNota.getCalificacion() >= 0 && nuevaNota.getCalificacion() <= 10) {
            notas.add(nuevaNota);
            System.out.println("Nota agregada correctamente.");
        } else {
            System.out.println("La calificación debe estar en el rango de 0 a 10.");
        }
    }

    public void modificaNota(String codigoMateria, double nuevaNota) {
        for (int i = 0; i < notas.size(); i++) {
            Nota notaExistente = notas.get(i);
            if (notaExistente.getMateria().getCodigo().equals(codigoMateria)) {
                if (nuevaNota >= 0 && nuevaNota <= 10) {
                    notaExistente.setCalificacion(nuevaNota);
                    System.out.println("Calificación modificada correctamente para la materia con código " + codigoMateria);
                } else {
                    System.out.println("La nueva calificación debe estar en el rango de 0 a 10.");
                }
                return;
            }
        }
        System.out.println("No se encontró una nota para la materia con código " + codigoMateria);
    }

    public double calcularPromedioNotasEstudiante() {
        if (notas.isEmpty()) {
            System.out.println("El estudiante no tiene notas registradas.");
            return 0.0;
        }
        double sumaNotas = 0.0;
        // Suma las calificaciones
        for (int i = 0; i < notas.size(); i++) {
            Nota nota = notas.get(i);
            sumaNotas += nota.getCalificacion();
        }
        double promedio = sumaNotas / notas.size();
        return promedio;
    }

    public void mostrar() {
        System.out.print("Estudiante [nombre=\"" + nombre + "\", apellido=\"" + apellido + "\", cedula=\"" + cedula + "\", notas=[");

        for (int i = 0; i < notas.size(); i++) {
            Nota nota = notas.get(i);
            Materia materia = nota.getMateria();
            System.out.print("{materia=\"" + materia.getNombre() + "\", calificacion=" + nota.getCalificacion() + "}");

            if (i < notas.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]]");
    }
}
