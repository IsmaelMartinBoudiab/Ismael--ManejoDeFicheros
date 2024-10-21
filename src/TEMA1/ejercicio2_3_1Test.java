package TEMA1;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class ejercicio2_3_1Test {

	    @Test
	    void crearDirectorio() throws IOException {
	        String nombreDirectorio = "directorio_prueba";
	        File directorio = new File(nombreDirectorio);
	        if (directorio.exists()) {
	            directorio.delete(); // Elimina el directorio si ya existe
	        }
	        ejercicio2_3_1.crearDirectorio(nombreDirectorio); // Llama al método que quieres probar
	        assertTrue(directorio.exists()); // Verifica que el directorio se creó
	    }
	    
		@Test
	    void crearFichero() throws IOException {
	        String nombreDirectorio = "directorio_prueba";
	        String nombreFichero = "archivo_prueba";
	        File directorio = new File(nombreDirectorio);
	        if (!directorio.exists()) {
	            directorio.mkdir(); // Crea el directorio si no existe
	        }
	        File ficheroCreado = ejercicio2_3_1.Crearfichero(nombreDirectorio, nombreFichero); // Llama al método que quieres probar
	        assertNotNull(ficheroCreado); // Verifica que el objeto File no es nulo
	        assertEquals(nombreFichero + ".txt", ficheroCreado.getName()); // Verifica que el nombre del archivo es correcto
	        assertTrue(ficheroCreado.exists()); // Verifica que el archivo se creó
	    }
	
	 @Test
	    void crearFicheroYPadre() throws IOException {
	        String nombreDirectorio = "directorio_prueba";
	        String nombreFichero = "archivo_prueba";
	        File directorioPadre = new File(nombreDirectorio);
	        if (!directorioPadre.exists()) {
	            directorioPadre.mkdir(); // Crea el directorio si no existe
	        }
	        File ficheroCreado = ejercicio2_3_1.CrearficheroyPadre(directorioPadre, nombreFichero); // Llama al método que quieres probar
	        assertNotNull(ficheroCreado); // Verifica que el objeto File no es nulo
	        assertEquals(nombreFichero + ".txt", ficheroCreado.getName()); // Verifica que el nombre del archivo es correcto
	        assertTrue(ficheroCreado.exists()); // Verifica que el archivo se creó
	    }
	
	@Test
	void renombrarFichero_ficheroExiste_renombraFicheroCorrecto() throws IOException {
		String nombreDirectorio = "directorio_prueba";
		String nombreFichero = "archivo_prueba";
		String nuevaCarpeta = "directorio_nuevo";
		String nuevoNombre = "archivo_nuevo";

		File directorioPadre = new File(nombreDirectorio);
		if (!directorioPadre.exists()) {
			directorioPadre.mkdir();
		}
		File ficheroOriginal = new File(directorioPadre, nombreFichero + ".txt");
		if (!ficheroOriginal.exists()) {
			ficheroOriginal.createNewFile();
		}

		// Crea el directorio de destino si no existe
		File nuevoDirectorio = new File(nuevaCarpeta);
		if (!nuevoDirectorio.exists()) {
			nuevoDirectorio.mkdir();
		}

		File nuevaUbi = new File(nuevaCarpeta, nuevoNombre + ".txt");

		// Llama al método que quieres probar
		ejercicio2_3_1.renombrarfichero(ficheroOriginal, nuevaCarpeta, nuevoNombre);

		// Verifica que el archivo original ya no existe
		assertFalse(ficheroOriginal.exists(), "El archivo original debería haberse eliminado");

		// Verifica que el archivo renombrado existe en la nueva ubicación
		assertTrue(nuevaUbi.exists(), "El archivo renombrado debería existir en la nueva ubicación");

		// Verifica que el nombre del archivo renombrado es correcto
		assertEquals(nuevoNombre + ".txt", nuevaUbi.getName(), "El nombre del archivo renombrado debería ser correcto");
	}
}






