package TEMA1;


import java.io.File;

public class ejercicio_2_1_1 {

    public static void main(String[] args) {
       
        File raiz = new File(".");

        
        for (File elemento : raiz.listFiles()) {
            if (elemento.isFile()) {
                System.out.println("Nombre del fichero: " + elemento.getName());
            } else if (elemento.isDirectory()) {
                System.out.println("Nombre del directorio: " + elemento.getName());
            }
        }
    }
}