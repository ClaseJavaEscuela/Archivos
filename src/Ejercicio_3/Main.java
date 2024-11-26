package Ejercicio_3;

public class Main {
    public static void main(String[] args){
        GeneradorReportes generador = new GeneradorReportes("Archivos/empleados.txt");
        generador.calcularSalarioTotalPorDepartamenti();
    }
}
