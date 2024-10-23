package TEMA1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Testejercicio4_1_1 {

    
	@Test
	void TestEscribeCoches() {
		ejercicio4_1_1 sol = new ejercicio4_1_1();
		String[] matriculas = {"8787CDZ", "7553XYQ", "4589BDA"};
		String[] marcas = {"Peugot", "Renault", "Mercedes"};
		int[] anios = {2015, 2023, 2020};		
		sol.EscribeCoches(matriculas, marcas, anios);
	}

	@Test
	void TestLeeCoches() {
		ejercicio4_1_1 sol = new ejercicio4_1_1();
		sol.LeeCoches();
	}

	@Test
	void TestBuscaCoches() {
		ejercicio4_1_1 sol = new ejercicio4_1_1();
		System.out.println("Se procede a buscar el coche con matrícula 7553XYQ.");
		sol.BuscaCocheConMatricula("7553XYQ");
		System.out.println("Se procede a buscar el coche con matrícula 8883XYQ.");
		sol.BuscaCocheConMatricula("8883XYQ");		
	}
}