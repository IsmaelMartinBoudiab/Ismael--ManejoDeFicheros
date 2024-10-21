package TEMA1;


import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ejercicio_2_2_1 {
	

	public void mostrarDirectoriosConCadena(String cadena) {
		File directorioRaiz = new File(".");
		File[] archivos = directorioRaiz.listFiles();

		if (archivos != null) {
			for (File archivo : archivos) {
				if (archivo.isDirectory() && archivo.getName().contains(cadena)) {

					System.out.println(" se ha encontrado el directorio: " + archivo.getPath());
				}
			}
		}
		else {
			System.out.println("no se encontro nada relacionado con su busqueda");
		}

	}
}
