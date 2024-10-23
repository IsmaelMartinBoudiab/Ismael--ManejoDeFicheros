package TEMA1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ejercicio3_2_2Test {

	@Test
	void TestEscribeCoches() {
		ejercicio3_2_2 sol = new ejercicio3_2_2();
		String[] matriculas = {"8787CDZ", "7553XYQ", "4589BDA"};
		String[] marcas = {"Peugot", "Renault", "Mercedes"};
		int[] anios = {2015, 2023, 2020};		
		sol.EscribeCoches(matriculas, marcas, anios);
	}
	
	@Test
	void TestEscribeCoches2() {
		ejercicio3_2_2 sol = new ejercicio3_2_2();
		sol.EscribeCoche("8787CDZ", "Peugot", 2015);
		sol.EscribeCoche("7553XYQ", "Renault", 2023);
		sol.EscribeCoche("4589BDA", "Mercedes", 2020);
	}

	@Test
	void TestLeeCoches() {
		ejercicio3_2_2 sol = new ejercicio3_2_2();
		sol.LeeCoches();
	}

}
