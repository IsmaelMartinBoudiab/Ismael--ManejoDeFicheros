package TEMA1;



import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;


public class Testejercicio3_2_1 {

    private static final String NOMBRE_FICHERO = "coches.dat";

    @Test
    void testCoches() {
        List<Coche> coches = new ArrayList<>();
        coches.add(new Coche("1234ABC", "Toyota", 2020));
        coches.add(new Coche("5678DEF", "Honda", 2022));
        coches.add(new Coche("9012GHI", "Ford", 2021));
        ejercicio3_2_1.serializarCoches(NOMBRE_FICHERO, coches);
        
        
        List<Coche> cochesDeserializados = ejercicio3_2_1.deserializarCoches(NOMBRE_FICHERO);

        
        assertEquals(coches, cochesDeserializados);
    }
}
