package TEMA1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ejercicio3_2_2 {

	public ejercicio3_2_2() {
		// TODO Auto-generated constructor stub
	}


	public void EscribeCoches(String[] matriculas, String[] marcas, int[] anios) {
		try {
			FileOutputStream fos = new FileOutputStream("coches_con_array.dat", true);
			DataOutputStream dos = new DataOutputStream(fos);	
			
			for (int i=0; i< matriculas.length; i++) {
				dos.writeUTF(matriculas[i]);
				dos.writeUTF(marcas[i]);
				dos.writeInt(anios[i]);
			}
			
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("¡Finalizada la ejecución del método EscribeCoches con arrays!");
		
	}

	public void EscribeCoche(String matricula, String marca, int anio) {
		try {
			FileOutputStream fos = new FileOutputStream("coches_con_array.dat", true);
			DataOutputStream dos = new DataOutputStream(fos);

			dos.writeUTF(matricula);
			dos.writeUTF(marca);
			dos.writeInt(anio);
			
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("¡Finalizada la ejecución del método EscribeCoches sin arrays!");
	}
	

	public void LeeCoches() {
		try {

			FileInputStream fis = new FileInputStream("coches_con_array.dat");
			DataInputStream dis = new DataInputStream(fis);
			
			String matricula = null;
			String marca = null;
			int anio=0;
			
			boolean salir = false;
			while(!salir) {
				try {
					matricula = dis.readUTF();
					marca = dis.readUTF();
					anio = dis.readInt();
				}catch(Exception  e){
					salir=true;					
				};
				
				if (!salir) {
					System.out.println(matricula + " - " + marca +  " " + anio);
				}
			};
			
			dis.close();
			
			System.out.println("¡Finalizada la ejecución del método LeeCoches!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

