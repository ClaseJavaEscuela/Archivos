package Ejercicio_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//1Juan30
//2Maria25
//3Carlos35
//4Sofia28
//5Andrés40
public class ConversorDeFormatos {
    private String ruta;
    private List<Map<String,String>> data;
    private String[] encabezados;

    public ConversorDeFormatos(String ruta){
        this.ruta = ruta;
    }

    public void leerArchivosCSV(){
        String linea;
        try(BufferedReader archivo = new BufferedReader((new FileReader(this.ruta)))){
            linea = archivo.readLine();
            String[] columnas = linea.split(",");
            encabezados = new String[columnas.length];

            while((linea = archivo.readLine())!= null){
                Map<String,String> persona = new HashMap<>();
                columnas = linea.split(",");
                for(int i=0; i<encabezados.length;i++){
                    persona.put(encabezados[i],columnas[i]);
                }
            }
            return ;
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
//
//    String jsonString = "{"
//            + "\"nombre\": \"Juan\","
//            + "\"edad\": 30,"
//            + "\"ciudad\": \"Madrid\""
//            + "}";
//
    private String JSONparse(List<Map<String,String>> data){
        String objeto = "{ ";



        return objeto;
    }


}
