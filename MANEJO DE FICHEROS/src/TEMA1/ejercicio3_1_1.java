package TEMA1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ejercicio3_1_1 {

    private File archivo;

    public ejercicio3_1_1(File archivo) {
        this.archivo = archivo;
    }

    public void escribirCadena(String cadena) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(cadena);
            writer.newLine();
            writer.write('*');
            writer.flush(); // Vaciar el buffer
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void escribirNombres(String[] nombres) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            for (String nombre : nombres) {
                writer.write(nombre);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void leerArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    char caracter = linea.charAt(i);
                    int valorASCII = (int) caracter;
                    System.out.println("Caracter: " + caracter + ", Valor ASCII: " + valorASCII);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        File archivo = new File("miArchivo.txt");

        ejercicio3_1_1 manejador = new ejercicio3_1_1(archivo);
        manejador.escribirCadena("Hola mundo!"); 
        manejador.escribirNombres(new String[]{"Juan", "Pedro", "María"});
        manejador.leerArchivo(); 
    }
}

