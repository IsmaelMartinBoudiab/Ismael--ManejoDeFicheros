package TEMA1;


import java.io.Serializable;

public class Coche implements Serializable{


	private static final long serialVersionUID = 1L;
	private String matricula;
	private String marca;
	private int anio;
	
	public Coche(String matricula, String marca, int anio) {
		// TODO Auto-generated constructor stub
		
		this.matricula = matricula;
		this.marca = marca;
		this.anio = anio;		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}	
	

}
