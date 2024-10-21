package TEMA1;


import java.io.Serializable;

public class Coche implements Serializable {
    private String matricula;
    private String marca;
    private int añoMatriculación;

    public Coche(String matricula, String marca, int añoMatriculación) {
        this.matricula = matricula;
        this.marca = marca;
        this.añoMatriculación = añoMatriculación;
    }

    // Getters y setters para los atributos
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

    public int getAñoMatriculación() {
        return añoMatriculación;
    }

    public void setAñoMatriculación(int añoMatriculación) {
        this.añoMatriculación = añoMatriculación;
    }
}