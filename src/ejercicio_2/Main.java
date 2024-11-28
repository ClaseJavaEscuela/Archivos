/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_2;

/**
 *
 * @author Alumnos
 * String regex = "\\[(INFO|ERROR|WARNING)\\] (.+)";
        
        Pattern pattern = Pattern.compile(regex);
 */
public class Main {
    public static void main(String[] args){
        Logs logs = new Logs("aplicacion.log");
        logs.buscadorDeMensajes(new String[]{"INFO", "ERROR", "WARNING"});
    }
}
