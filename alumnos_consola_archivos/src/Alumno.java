import java.util.ArrayList;

public class Alumno {
    private String codigo;
    private String nombre;
    private String apellido;
    private String curso;
    private String dni;
    private ArrayList<Materia> materia;

    public Alumno(String codigo, String nombre, String apellido, String curso, String dni) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.dni = dni;
        this.materia = new ArrayList<>(); 
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCurso() {
        return curso;
    }

    public String getDni() {
        return dni;
    }

    public ArrayList<Materia> getMateria() {
        return materia;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setMateria(Materia materia) {
        this.materia.add(materia);
    }
}
