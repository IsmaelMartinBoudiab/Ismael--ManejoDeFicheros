package TEMA1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ejercicio3_2_1 {

	public ejercicio3_2_1() {
		// TODO Auto-generated constructor stub
	}


	public void EscribeCoches(String[] matriculas, String[] marcas, int[] anios) {
		try {
			FileOutputStream fos = new FileOutputStream("coches_con_array.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);	
			
			for (int i=0; i< matriculas.length; i++) {
				Coche c = new Coche(matriculas[i], marcas[i], anios[i]);	
				oos.writeObject(c);
			}
			
			oos.close();
			System.out.println("¡Finalizada la ejecución del método EscribeCoches pasando las variables con arrays!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void EscribeCoche(String matricula, String marca, int anio) {
		try {
			Coche c = new Coche(matricula, marca, anio);
			FileOutputStream fos = new FileOutputStream("coches.dat", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);		

			oos.writeObject(c);
			
			oos.close();
			System.out.println("¡Finalizada la ejecución del método EscribeCoches pasando las variables sin arrays!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void LeeCochesConArrays() {
		try {

			FileInputStream fis = new FileInputStream("coches_con_array.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Coche c = null;
			boolean salir = false;
			while(!salir) {
				try {
					c = (Coche) ois.readObject();
				}catch(Exception  e){
					salir=true;					
				};
				
				if (!salir) {
					System.out.println(c.getMatricula() + " - " + c.getMarca() +  " " + c.getAnio());
				}
			};
			
			ois.close();

			System.out.println("¡Finalizada la ejecución del método LeeCochesConArrays!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void LeeCochesSinArrays() {
		try {

			FileInputStream fis = new FileInputStream("coches.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Coche c = null;
			boolean salir = false;
			while(!salir) {
				try {
					c = (Coche) ois.readObject();
				}catch(Exception  e){
					salir=true;					
				};
				
				if (!salir) {
					System.out.println(c.getMatricula() + " - " + c.getMarca() +  " " + c.getAnio());
				}
			};
			
			ois.close();

			System.out.println("¡Finalizada la ejecución del método LeeCochesSinArrays!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
