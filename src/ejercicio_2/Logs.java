/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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

    public Logs(String ruta, String[] mensajes) {
        this.ruta = ruta;
        this.numeroMensajes = new HashMap<>();
        this.expresiones = new Pattern[mensajes.length];
        inicializar(mensajes);
        inicializarExpresiones(mensajes);
    }

    private void inicializarExpresiones(String[] mensajes) {
        for (int i =0; i<mensajes.length;i++) {
            String regex = "\\["+mensajes[i]+"\\](.+)";
            Pattern expresion = Pattern.compile(regex);
            this.expresiones[i] = expresion;
        }
    }
    
    private List<String> leerArchivos(){
        return null;
    }

    public Map<String, Integer> contarMensajes() {

        return this.numeroMensajes;
    }

}
