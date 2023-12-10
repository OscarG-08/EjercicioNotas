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
public class Curso {

    private ArrayList<Estudiante> estudiantes;

    public Curso() {
        this.estudiantes = new ArrayList<>();
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String buscarEstudiantePorCedula(Estudiante estudiante) {
        String cedulaBuscar = estudiante.getCedula();

        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante est = estudiantes.get(i);
            if (est.getCedula().equals(cedulaBuscar)) {
                return "El estudiante con cédula " + cedulaBuscar + " ya está registrado en el curso.";
            }
        }

        return null;
    }

    public void matricularEstudiantes(Estudiante estudiante) {
        if (buscarEstudiantePorCedula(estudiante) == null) {
            estudiantes.add(estudiante);
            System.out.println("Estudiante matriculado correctamente en el curso.");
        } else {
            System.out.println("El estudiante ya está registrado en el curso.");
        }
    }

    public double calcularPromedioCurso() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en el curso para calcular el promedio.");
            return 0.0;
        }
        double sumaPromedios = 0.0;
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante estudiante = estudiantes.get(i);
            sumaPromedios += estudiante.calcularPromedioNotasEstudiante();
        }
        double promedioCurso = sumaPromedios / estudiantes.size();

        return promedioCurso;
    }

    public void mostrar() {
        System.out.print("Clase [");

        if (estudiantes != null && !estudiantes.isEmpty()) {
            System.out.print("estudiantes=");
            for (int i = 0; i < estudiantes.size(); i++) {
                Estudiante estudiante = estudiantes.get(i);

                System.out.print("{nombre=" + estudiante.getNombre() +
                        ", apellido=" + estudiante.getApellido() +
                        ", cedula=" + estudiante.getCedula() +
                        ", notas=[");

                if (estudiante.getNotas() != null && !estudiante.getNotas().isEmpty()) {
                    for (int j = 0; j < estudiante.getNotas().size(); j++) {
                        Nota nota = estudiante.getNotas().get(j);
                        Materia materia = nota.getMateria();
                        System.out.print("{materia=" + materia.getNombre() +
                                ", calificacion=" + nota.getCalificacion() + "}");

                        if (j < estudiante.getNotas().size() - 1) {
                            System.out.print(", ");
                        }
                    }
                }
                System.out.print("]}");
                if (i < estudiantes.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println("]");
    }

}
