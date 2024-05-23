package com.izo.ejercicio1;

public class Materia {
    private String codigo;
    private String nombre;
    private int nota;

    public Materia(String codigo, String nombre, int nota) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nota = nota; 
    }

    public String getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
