import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    @SuppressWarnings("resource")
    static Scanner scanner = new Scanner(System.in);

    static int opciones = 0;

    public static void main(String[] args) throws Exception {
        // Instancia de alumnos
        List<Alumno> alumnos = new ArrayList<>();
        List<Materia> materias = new ArrayList<>();

        // Visor por terminal
        do {
            System.out.println("===== Sistema de Alumnado ====");
            System.out.println("Lista de opciones disponibles:");
            System.out.println("1. VER ALUMNOS");
            System.out.println("2. CARGAR ALUMNOS");
            System.out.println("3. VER MATERIAS");
            System.out.println("4. CARGAR MATERIAS");
            System.out.println("5. ASIGNAR MATERIAS A ALUMNOS");
            System.out.println("6. VER MATERIAS DE ALUMNOS");
            System.out.println("0. SALIR");

            System.out.print("Introduce una opción: ");
            opciones = scanner.nextInt();

            switch (opciones) {
                case 1:
                    verAlumnos(alumnos);
                    break;

                case 2:
                    cargarAlumnos(alumnos);
                    break;

                case 3:
                    verMaterias(materias);
                    break;

                case 4:
                    cargarMaterias(materias);
                    break;

                case 5:
                    cargarAlumnosMaterias(alumnos, materias);
                    break;

                case 6:
                    verAlumnosMaterias(alumnos, materias);
                    break;

                default:
                    break;
            }

        } while (opciones > 0);
    }

    public static void cargarAlumnos(List<Alumno> alumnos) {
        scanner.nextLine();

        System.out.println("Ingrese el código del alumno: ");
        String codigoAlumno = scanner.nextLine();

        System.out.println("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del alumno: ");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese el curso del alumno: ");
        String curso = scanner.nextLine();

        System.out.println("Ingrese el DNI del alumno: ");
        String dni = scanner.nextLine();

        Alumno alumno = new Alumno(codigoAlumno, nombre, apellido, curso, dni);

        alumnos.add(alumno);
    }

    public static void cargarMaterias(List<Materia> materias) {
        scanner.nextLine();

        System.out.println("Ingresar el codigo de la materia");
        String codigoMateria = scanner.nextLine();

        System.out.println("Ingresar nombre de la materia");
        String nombreMateria = scanner.nextLine();

        Materia materia = new Materia(codigoMateria, nombreMateria);

        materias.add(materia);
    }

    public static void cargarAlumnosMaterias(List<Alumno> alumnos, List<Materia> materias) {
        int count = 0;
        int countMaterias = 0;
        int cargarMateria = 1;

        System.out.println("Lista alumnos para asignarles materias: ");

        for (Alumno alumno : alumnos) {
            count++;
            System.out.println(count + "." + " " + alumno.getNombre() + " " + alumno.getApellido());
        }

        System.out.println("Seleccionar numero del alumno para cargar materias: ");
        int alumnoIndex = scanner.nextInt() - 1;

        Alumno alumnoSeleccionado = alumnos.get(alumnoIndex);

        System.out.println("Lista alumnos para asignarles materias: ");

        for (Materia materia : materias) {
            countMaterias++;
            System.out.println(countMaterias + "." + " " + materia.getNombre());
        }

        do {
            System.out.println("Seleccionar numero de materia para asignarlo al alumno: ");
            int materiaIndex = scanner.nextInt() - 1;

            alumnoSeleccionado.setMateria(materias.get(materiaIndex));

            System.out.println("Deseas agregar otra materia al alumno " + alumnoSeleccionado.getNombre() + " " +
                    alumnoSeleccionado.getApellido() + "? (ingresar '1' para seguir cargando, '0' para salir)");
            cargarMateria = scanner.nextInt();

        } while (cargarMateria > 0);

        cargarDatosArchivo(alumnoSeleccionado);

    }

    public static void cargarDatosArchivo(Alumno alumnoSeleccionado) {
        String path = "D:/sistema/Documentos/PROYECTOS - VARIOS LENGUAJES/Proyectos - Java/Ejercicios - IZO/alumnos_consola_archivos/src/docs/alumnosMaterias.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(alumnoSeleccionado.getNombre() + " " + alumnoSeleccionado.getApellido());
            bw.newLine();
            for (int i = 0; i < alumnoSeleccionado.getMateria().size(); i++) {
                bw.write("  " + alumnoSeleccionado.getMateria().get(i).getNombre());
                bw.newLine();
            }
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void verAlumnos(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.printf("| %-8s | %-13s | %-13s | %-8s | %-13s |\n",
                    alumno.getCodigo(),
                    alumno.getNombre(),
                    alumno.getApellido(),
                    alumno.getCurso(),
                    alumno.getDni());
        }
    }

    public static void verMaterias(List<Materia> materias) {
        for (Materia materia : materias) {
            System.out.printf("| %-8s | %-13s |\n",
                    materia.getCodigo(),
                    materia.getNombre());
        }
    }

    public static void verAlumnosMaterias(List<Alumno> alumnos, List<Materia> materias) {
        String path = "D:/sistema/Documentos/PROYECTOS - VARIOS LENGUAJES/Proyectos - Java/Ejercicios - IZO/alumnos_consola_archivos/src/docs/alumnosMaterias.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
