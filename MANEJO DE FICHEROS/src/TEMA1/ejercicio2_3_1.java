package TEMA1;


import java.io.File;
import java.io.IOException;
/**
 * @author Ismael
 * @version 1.0
 */
public class ejercicio2_3_1 {

    /**
     * Crea un directorio si no existe.
     *
     * @param nombreDirectorio El nombre del directorio a crear.
     * 
     */
    public static void crearDirectorio(String nombreDirectorio) throws IOException {
        File directorio = new File(nombreDirectorio);
        if (!directorio.exists()) {
            if (directorio.mkdir()) {
                System.out.println("Directorio creado correctamente: " + nombreDirectorio);
            } else {
                throw new IOException("No se pudo crear el directorio: " + nombreDirectorio);
            }
        } else {
            System.out.println("El directorio ya existe: " + nombreDirectorio);
        }
    }

    /**
     * Crea un fichero dentro de un directorio.
     *
     * @param nombreDirectorio El nombre del directorio donde se creara el fichero.
     * @param nombreFichero El nombre del fichero a crear.
     * @return El objeto File que representa el fichero creado.
     * 
     */
    public static File Crearfichero(String nombreDirectorio, String nombreFichero) throws IOException {
        File directorio = new File(nombreDirectorio);
        if (!directorio.exists()) {
            throw new IOException("El directorio no existe: " + nombreDirectorio);
        }
        File fichero = new File(directorio, nombreFichero + ".txt");
        if (fichero.createNewFile()) {
            System.out.println("Fichero creado correctamente: " + fichero.getAbsolutePath());
            return fichero;
        } else {
            throw new IOException("No se pudo crear el fichero: " + fichero.getAbsolutePath());
        }
    }

    /**
     * Crea un fichero dentro de un directorio padre.
     *
     * @param directoriopadre El directorio padre donde se creara el fichero          .
     * @param nombrefichero El nombre del fichero a crear.
     * @return El objeto File que representa el fichero creado.
     * 
     */
    public static File CrearficheroyPadre(File directoriopadre, String nombrefichero) throws IOException {
        if (!directoriopadre.exists()) {
            throw new IOException("El directorio padre no existe: " + directoriopadre.getAbsolutePath());
        }
        File fichero = new File(directoriopadre, nombrefichero + ".txt");
        if (fichero.createNewFile()) {
            System.out.println("Fichero creado correctamente: " + fichero.getAbsolutePath());
            return fichero;
        } else {
            throw new IOException("No se pudo crear el fichero: " + fichero.getAbsolutePath());
        }
    }

    /**
     * Renombra un fichero y lo mueve a una nueva carpeta.
     *
     * @param fichero El fichero a renombrar.
     * @param nuevaCarpeta La nueva carpeta donde se movera el fichero.
     * @param nuevonombre El nuevo nombre del fichero.
     * 
     */
    public static void renombrarfichero(File fichero, String nuevaCarpeta, String nuevonombre) throws IOException {
        if (!fichero.exists()) {
            throw new IOException("El fichero no existe: " + fichero.getAbsolutePath());
        }

        File nuevaUbi = new File(nuevaCarpeta, nuevonombre + ".txt");
        if (fichero.renameTo(nuevaUbi)) {
            System.out.println("Fichero renombrado correctamente: " + fichero.getAbsolutePath() + " a " + nuevaUbi.getAbsolutePath());
        } else {
            throw new IOException("No se pudo renombrar/mover el fichero: " + fichero.getAbsolutePath());
        }
    }
}