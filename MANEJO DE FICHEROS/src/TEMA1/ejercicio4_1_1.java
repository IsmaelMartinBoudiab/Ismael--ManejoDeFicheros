package TEMA1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ejercicio4_1_1 {

		public ejercicio4_1_1() {
			// TODO Auto-generated constructor stub
		}
		
		public void EscribeCoches(String[] matriculas, String[] marcas, int[] anios) {
			try {
				FileOutputStream fos = new FileOutputStream("buscar.obj");
				ObjectOutputStream oos = new ObjectOutputStream(fos);	
				
				for (int i=0; i< matriculas.length; i++) {
					Coche c = new Coche(matriculas[i], marcas[i], anios[i]);	
					oos.writeObject(c);
				}
				
				oos.close();
				System.out.println("¡Finalizada la ejecución del método EscribeCoches!");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

		public void LeeCoches() {
			try {

				FileInputStream fis = new FileInputStream("buscar.obj");
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
				System.out.println("¡Finalizada la ejecución del método LeeCoches!");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}


		public void BuscaCocheConMatricula(String matricula) {
			try {

				FileInputStream fis = new FileInputStream("buscar.obj");
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				Coche c = null;
				boolean salir = false;
				int coches_leidos = 0;
				while(!salir) {
					try {
						c = (Coche) ois.readObject();
					}catch(Exception  e){
						salir=true;					
					};
					
					if (!salir) {
						coches_leidos++;
						if (matricula.equals(c.getMatricula()))
						{
							System.out.printf("El coche con matrícula %s es de tipo %s y se ha matriculado en el año %d." + System.lineSeparator(), c.getMatricula(), c.getMarca(), c.getAnio());
							System.out.printf("Para esta operación se han leido %d coches."+ System.lineSeparator(), coches_leidos);
							System.out.println("¡Finalizada la ejecución del método BuscaCocheConMatricula!");

							ois.close();
							return;
						}
					}
				};
				
				ois.close();

				System.out.printf("No hay registrado ningún coche con matrícula %s."+ System.lineSeparator(), matricula);
				System.out.println("¡Finalizada la ejecución del método BuscaCocheConMatricula!");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
