package TEMA1;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ejercicio3_2_1 {

	    public static void serializarCoches(String nombreFichero, List<Coche> coches) {
	        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
	            out.writeObject(coches);
	        } catch (IOException e) {
	            System.err.println("Error al serializar los coches: " + e.getMessage());
	        }
	    }

	    public static List<Coche> deserializarCoches(String nombreFichero) {
	        List<Coche> coches = new ArrayList<>();
	        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreFichero))) {
	            coches = (List<Coche>) in.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            System.err.println("Error al deserializar los coches: " + e.getMessage());
	        }
	        return coches;
	    }
	}