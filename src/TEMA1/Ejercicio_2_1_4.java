package TEMA1;


import java.io.File;
import java.io.IOException;

public class Ejercicio_2_1_4{
	
// Método para crear un directorio y un fichero
	public boolean CrearDirectorioYFichero4() {

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
			
			e.printStackTrace();
		}

		return D.exists() && D.exists();
	}

	
// Método para eliminar un directorio y un fichero
	public boolean EliminarDirectorioYFichero4() {
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

// Método para mostrar informacion un directorio y un fichero
	public void mostrarInformacionFichero4() {
		File D = new File("C:/directorios_y_ficheros/prueba");
		System.out.println("Nombre del fichero: " + D.getName());
		System.out.println("Ruta del fichero: " + D.getPath());
		System.out.println("Ruta absoluta del fichero: " + D.getAbsolutePath());
		System.out.println("Se puede leer del fichero: " + D.canRead());
		System.out.println("Se puede escribir en el fichero: " + D.canWrite());
		System.out.println("Tamaño del fichero: " + D.length() + " bytes");
		System.out.println("Directorio padre: " + D.getParent());

	}
// Método para mostrar el tamaño de cada directorio padre
	public void tamañodirectoriopadre4() {
		File D = new File("C:\\programacion\\EquiposDeOficinaProfesor\\bin\\paquete1");
		if (D.exists()) {
			long tamañoTotal = 0;
			File[] archivos = D.listFiles();
			if (archivos != null) {
				for (File archivo : archivos) {
					if (archivo.isFile()) {
						tamañoTotal += archivo.length();
					} else if (archivo.isDirectory()) {
						// Calcula el tamaño del subdirectorio recursivamente
						tamañoTotal += calcularTamañoDirectorio(archivo);
					}
				}
			}
			System.out.println("Tamaño del directorio " + D.getAbsolutePath() + ": " + tamañoTotal + " bytes");

			File padre = D.getParentFile();
			while (padre != null) {
				tamañoTotal = 0; // Reinicia el tamaño total para cada directorio padre
				archivos = padre.listFiles();
				if (archivos != null) {
					for (File archivo : archivos) {
						if (archivo.isFile()) {
							tamañoTotal += archivo.length();
						} else if (archivo.isDirectory()) {
							// Calcula el tamaño del subdirectorio recursivamente
							tamañoTotal += calcularTamañoDirectorio(archivo);
						}
					}
				}
				System.out.println("Tamaño del directorio " + padre.getAbsolutePath() + ": " + tamañoTotal + " bytes");
				padre = padre.getParentFile();
			}
		} else {
			System.out.println("El directorio no existe.");
		}
	}

// Función auxiliar para calcular el tamaño de un directorio
	private long calcularTamañoDirectorio(File directorio) {
		long tamañoTotal = 0;
		File[] archivos = directorio.listFiles();
		if (archivos != null) {
			for (File archivo : archivos) {
				if (archivo.isFile()) {
					tamañoTotal += archivo.length();
				} else if (archivo.isDirectory()) {
					tamañoTotal += calcularTamañoDirectorio(archivo); // Llamada recursiva
				}
			}
		}
		return tamañoTotal;
	}
}	