package Ejercicio_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
        this.data = new ArrayList<>();
    }

    public void leerArchivosCSV(){
        String linea;
        try(BufferedReader archivo = new BufferedReader((new FileReader(this.ruta)))){
            linea = archivo.readLine();
            String[] columnas = linea.split(",");
            this.encabezados = new String[columnas.length];
            this.encabezados = columnas;

            while((linea = archivo.readLine())!= null){
                Map<String,String> persona = new HashMap<>();
                columnas = linea.split(",");
                for(int i=0; i<encabezados.length;i++){
                    persona.put(encabezados[i],columnas[i]);
                }
                data.add(persona);
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
    private String JSONparse(){

        String objeto = "[ ";
        int numeroObjetos = this.data.size();
        int indiceObjetos = 0;
        for(Map<String,String>objetoPersona: this.data){
            String subObjeto = "{";
            int longitudDelObjeto = objetoPersona.size();
            int indice = 0;
            for(String llave: objetoPersona.keySet() ){
                subObjeto += "\""+llave+"\""+":"+"\""+objetoPersona.get(llave)+"\"";

                if(indice < longitudDelObjeto -1){
                    subObjeto += ",";
                }
                indice ++;
            }
            objeto += "\n"+"    "+subObjeto+"}";
            if(indiceObjetos < numeroObjetos -1){
                objeto += ",";
            }
            indiceObjetos++;
        }
        objeto += "\n]";
        return objeto;
    }
    private void escribirJSON(String data){
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter("datos.json"))){
            escritor.write(data);
            System.out.println("\nSe acabo\n");
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void convertirArchivosCSV(){
        leerArchivosCSV();
        String data = JSONparse();
        escribirJSON(data);
    }

}
