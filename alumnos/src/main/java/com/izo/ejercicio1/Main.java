package com.izo.ejercicio1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String[] nombres = { "Juan", "María", "Carlos", "Ana", "Pedro", "Laura", "Diego", "Sofía", "Lucas",
                "Valentina" };
        String[] apellidos = { "García", "Rodríguez", "Martínez", "López", "González", "Pérez", "Sánchez", "Romero",
                "Fernández", "Díaz" };
        String[] cursos = { "1A", "2B", "3C", "4D", "5E" };
        String[] dniss = { "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777",
                "88888888", "99999999", "00000000" };
        String[] materias = { "Matemáticas", "Lengua", "Geografía", "Historia", "Física" };

        // Bucle inicial para generar los 100 alumnos
        for (int i = 1; i <= 100; i++) {
            String codigo = "AL" + i;
            String nombre = nombres[(int) (Math.random() * nombres.length)];
            String apellido = apellidos[(int) (Math.random() * apellidos.length)];
            String curso = cursos[(int) (Math.random() * cursos.length)];
            String dni = dniss[(int) (Math.random() * dniss.length)];

            // Generamos las instancias de la clase alumno
            Alumno alumno = new Alumno(codigo, nombre, apellido, curso, dni);

            // Segundo bucle para generar instancias de la clase Materia y setearlas a la
            // lista de alumnos de materias
            for (int j = 0; j < 5; j++) {
                Materia materia = new Materia("M" + (int) (Math.random() * 10) + 1, materias[j],
                        (int) ((Math.random() * 10) + 1));
                alumno.setMateria(materia);
            }
            alumnos.add(alumno);
        }

        // Imprimir los alumnos generados
        for (Alumno alumno : alumnos) {
            String materiasStr = "";
            for (Materia materia : alumno.getMateria()) {
                materiasStr += materia.getNombre() + " (Nota: " + materia.getNota() + "), ";
            }
            if (materiasStr.length() > 0) {
                materiasStr = materiasStr.substring(0, materiasStr.length() - 2);
            }
            // Formato tabla
            System.out.println(
                    "+----------+---------------+---------------+----------+---------------+------------------------------------------------------------------------------------------------------+");
            
                    System.out.printf("| %-8s | %-13s | %-13s | %-8s | %-13s | %-30s |\n", "Codigo", "Nombre", "Apellido", "Curso", "Dni", "Materias");

            System.out.printf("| %-8s | %-13s | %-13s | %-8s | %-13s | %-30s |\n",
                    alumno.getCodigo(),
                    alumno.getNombre(),
                    alumno.getApellido(),
                    alumno.getCurso(),
                    alumno.getDni(),
                    materiasStr);
            System.out.println(
                    "+----------+---------------+---------------+----------+---------------+------------------------------------------------------------------------------------------------------+");
        }
    }
}