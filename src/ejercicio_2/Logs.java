/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_2;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.ArrayList;

/**
 *
 * @author Alumnos
 */
public class Logs {

    private String ruta;
    private Map<String, Integer> numeroMensajes;
    private Pattern[] expresiones;

    private void inicializar(String[] mensajes) {
        for (String mensaje : mensajes) {
            this.numeroMensajes.put(mensaje, 0);
        }
        return;
    }

    public Logs(String ruta) {
        this.ruta = ruta;
        this.numeroMensajes = new HashMap<>();

    }

    private void inicializarExpresiones(String[] mensajes) {
        for (int i =0; i<mensajes.length;i++) {
            String regex = "\\["+mensajes[i]+"\\](.+)";
            Pattern expresion = Pattern.compile(regex);
            this.expresiones[i] = expresion;
        }
    }

    private List<String> leerArchivos() {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader archivo = new BufferedReader(new FileReader(this.ruta))) {
            String linea;
            while ((linea = archivo.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("No se logro encontrar el archivo");
        }
        return lineas;
    }

    private void escribirResultados(){
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter("resultados.txt"))){
            for(String resultado: numeroMensajes.keySet()){
                escritor.write(resultado + " : " + numeroMensajes.get(resultado) + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void contarMensajes(String[] mensajes) {
        List<String> mensajesLeidos =  leerArchivos();
        this.expresiones = new Pattern[mensajes.length];

        inicializar(mensajes);
        inicializarExpresiones(mensajes);

        for(String mensaje : mensajesLeidos){
            for(int i=0; i<mensajes.length;i++){
                if(expresiones[i].matcher(mensaje).matches()){
                    numeroMensajes.put(mensajes[i], numeroMensajes.get(mensajes[i])+1);
                }
            }
        }
        return ;
    }

    public void buscadorDeMensajes(String[] mensajes){
        contarMensajes(mensajes);
        escribirResultados();
        System.out.println("Busqueda terminada");
    }

}
