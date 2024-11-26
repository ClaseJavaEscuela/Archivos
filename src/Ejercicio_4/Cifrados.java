package Ejercicio_4;

import Ejercicio_3.Trabajador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Cifrados {
    private static String cifrar(String texto){
        String textoCifrado = "";
        texto = texto.toLowerCase();
        for(char letra: texto.toCharArray() ){

            if(letra == ' '){
                textoCifrado += letra;
                continue;
            }
            int codigoAscii = (int) letra;

            if (codigoAscii >= 97 && codigoAscii <= 122) {
                // Aplicar ROT13
                codigoAscii += 13;
                if (codigoAscii > 122) {
                    codigoAscii -= 26;
                }
                textoCifrado += (char) codigoAscii;
            } else {

                textoCifrado += letra;
            }

        }

        return textoCifrado;
    }
    private static String decifrar(String texto){
        String textoDecifrado = "";
        texto = texto.toLowerCase();
        for(char letra: texto.toCharArray() ){

            if(letra == ' '){
                textoDecifrado += letra;
                continue;
            }
            int codigoAscii = (int) letra;

            if (codigoAscii >= 97 && codigoAscii <= 122) {
                // Aplicar ROT13
                codigoAscii -= 13;
                if (codigoAscii < 97) {
                    codigoAscii += 26;
                }
                textoDecifrado += (char) codigoAscii;
            } else {

                textoDecifrado += letra;
            }

        }

        return textoDecifrado;
    }
    private static String leerArchivo(String ruta){
        String texto = "";
        try(BufferedReader archivo = new BufferedReader(new FileReader(ruta))){
            String renglon = "";
            while ((renglon = archivo.readLine()) != null) {
                texto += renglon;
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return texto;
    }

    public static void decifrarRot13(String ruta){
        String texto = leerArchivo(ruta);
        System.out.println(texto+"\n");
        String textoDecifrado = decifrar(texto);
        System.out.println("Texto decifrado: \n"+textoDecifrado);
    }

    public static void Rot13(String texto, String ruta){
        //metodo de cifrado
        String textoCifrado = cifrar(texto);
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta))) {
            escritor.write(textoCifrado);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
