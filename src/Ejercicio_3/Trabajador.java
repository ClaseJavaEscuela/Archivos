package Ejercicio_3;

public class Trabajador {
    private double ID;
    private String nombre;
    private String departamento;
    private double salario;

    public Trabajador(double ID, String nombre, String departamento, double salario){
        this.ID = ID;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
    }

    public double getID() {
        return ID;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getSalario() {
        return this.salario;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}