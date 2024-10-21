package TEMA1;


import java.io.File;
import java.io.IOException;

public class ejercicio2_1_3 {
	
	
// Método para crear un directorio y un fichero
	public boolean CrearDirectorioYFichero2() {

		File D = new File("C:/directorios_y_ficheros/prueba");
		File F = new File(D, "fichero_prueba.txt");
		try {
			if (!D.exists()) {
				D.mkdirs();
				System.out.println("Directorio ha sido creado");
			}

			if (!F.exists()) {
				F.createNewFile();
				System.out.println("Fichero ha sido creado");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return D.exists() && D.exists();
	}
// Método para eliminar un directorio y un fichero

	public boolean EliminarDirectorioYFichero2() {
		File D = new File("C:/directorios_y_ficheros/prueba");
		File D2 = new File("C:/directorios_y_ficheros");
		File F = new File(D, "fichero_prueba.txt");

		if (F.exists()) {
			F.delete();
			System.out.println("Fichero ha sido eliminado");
		}

		if (D.exists()) {
			D.delete();
			System.out.println("Directorio ha sido eliminado");
		}
		if (D2.exists()) {
			D2.delete();
			System.out.println("Directorio ha sido eliminado");
		}

		return !D.exists() && !F.exists() && !D2.exists();
	}

	public void mostrarInformacionFichero2() {
		 File D = new File("C:/directorios_y_ficheros/prueba");
		 System.out.println("Nombre del fichero: " + D.getName());
		 System.out.println("Ruta del fichero: " + D.getPath());
		 System.out.println("Ruta absoluta del fichero: " + D.getAbsolutePath());
		 System.out.println("Se puede leer del fichero: " + D.canRead());
		 System.out.println("Se puede escribir en el fichero: " + D.canWrite());
		 System.out.println("Tamaño del fichero: " + D.length() + " bytes");
		 System.out.println("Directorio padre: "+D.getParent());}
}
