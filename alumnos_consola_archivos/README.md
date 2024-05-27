## Consideraciones
En las funciones `cargarDatosArchvios` y `verAlumnosMaterias` que podes encontrar dentro la clase `App.java` hay una variable llamada path que deberan modificar para poder interactuar con el archivo de texto alumnosMaterias colocando la ruta del archivo de su computadora.

```java
public static void cargarDatosArchivo(Alumno alumnoSeleccionado) {
  String path = "D:/sistema/Documentos/PROYECTOS - VARIOS LENGUAJES/Proyectos - Java/Ejercicios - IZO/alumnos_consola_archivos/src/docs/alumnosMaterias.txt"; // -> Modificar
  ...
}

public static void verAlumnosMaterias(List<Alumno> alumnos, List<Materia> materias) {
  String path = "D:/sistema/Documentos/PROYECTOS - VARIOS LENGUAJES/Proyectos - Java/Ejercicios - IZO/alumnos_consola_archivos/src/docs/alumnosMaterias.txt"; // -> Modificar
  ...
}
```
