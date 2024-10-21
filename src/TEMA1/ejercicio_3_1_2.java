package TEMA1;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ejercicio_3_1_2 {

    private static final String ARCHIVO = "datos.txt";
    private static final int NUMERO_ITERACIONES = 10000;

    public static void main(String[] args) {
        
        generarArchivo(ARCHIVO, NUMERO_ITERACIONES);

        
        long inicioFileReader = System.currentTimeMillis();
        escribirConFileReader(ARCHIVO);
        long finFileReader = System.currentTimeMillis();
        long tiempoFileReader = finFileReader - inicioFileReader;

      
        long inicioBufferedReader = System.currentTimeMillis();
        escribirConBufferedReader(ARCHIVO);
        long finBufferedReader = System.currentTimeMillis();
        long tiempoBufferedReader = finBufferedReader - inicioBufferedReader;

        
        System.out.println("Tiempo de escritura con FileReader/FileWriter: " + tiempoFileReader + " ms");
        System.out.println("Tiempo de escritura con BufferedReader/BufferedWriter: " + tiempoBufferedReader + " ms");

        
        long diferencia = tiempoFileReader - tiempoBufferedReader;
        System.out.println("Diferencia de tiempo: " + diferencia + " ms");
    }

    private static void generarArchivo(String nombreArchivo, int numeroIteraciones) {
        try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
            for (int i = 0; i < numeroIteraciones; i++) {
                writer.println("Línea " + i);
            }
        } catch (IOException e) {
            System.err.println("Error al generar el archivo: " + e.getMessage());
        }
    }

    private static void escribirConFileReader(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            for (int i = 0; i < NUMERO_ITERACIONES; i++) {
                writer.write("Línea " + i + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir con FileReader/FileWriter: " + e.getMessage());
        }
    }

    private static void escribirConBufferedReader(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            for (int i = 0; i < NUMERO_ITERACIONES; i++) {
                writer.write("Línea " + i + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir con BufferedReader/BufferedWriter: " + e.getMessage());
        }
    }
}
