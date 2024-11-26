package Ejercicio_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneradorReportes {
    private String ruta;
    private List<Trabajador> trabajadores;
    private Map<String,Double> departamentos;

    public GeneradorReportes(String ruta) {
        this.ruta = ruta;
        this.trabajadores = new ArrayList<>();
        this.departamentos = new HashMap<>();
        getData();
    }

    private void getData(){

        try(BufferedReader archivo = new BufferedReader(new FileReader(this.ruta))){
            String[] datos = new String[4];
            String linea = archivo.readLine();

            while ((linea = archivo.readLine()) != null) {

                linea = linea.replace("\"", "");
                System.out.println();
                datos = linea.split(",");
                trabajadores.add(new Trabajador(Double.parseDouble(datos[0]), datos[1], datos[2], Double.parseDouble(datos[3]) ) );
                // obtenemos todos los departamentos
                if(!departamentos.containsKey(datos[2])){
                    departamentos.put(datos[2],0.0);
                }
            }

            return ;
        }catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }

    public void calcularSalarioTotalPorDepartamenti(){

        for(String departamento: departamentos.keySet()){
            double salarioTotal = 0;
            for(Trabajador trabajador: trabajadores){
                if(trabajador.getDepartamento().equals(departamento)){
                    salarioTotal += trabajador.getSalario();
                }
            }
            departamentos.put(departamento, salarioTotal);
        }

        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(" reporte_departamentos.txt"))){
            escritor.write(("Reporte de salarios por departamentos"));
            for(String departamento: departamentos.keySet()){
                escritor.write(("\n"+departamento+" : "+departamentos.get(departamento)));
            }
            System.out.println("Se acabo");
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }

        return ;
    }



}
