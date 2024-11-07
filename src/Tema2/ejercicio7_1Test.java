package Tema2;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;

import static org.junit.Assert.fail;

public class ejercicio7_1Test {

    // Configuración inicial que se ejecuta una vez antes de todos los tests.
    // Intenta cargar las configuraciones necesarias para la base de datos desde el archivo "bd.config".
    @BeforeClass
    public static void setup() {
        try {
            ejercicio7_1.cargarConfiguracion("bd.config");
        } catch (Exception e) {
            System.err.println("Error al cargar la configuración en el setup de pruebas.");
            e.printStackTrace();
            fail("Falló la carga de configuración.");
        }
    }

    // Test para verificar si la tabla se crea correctamente en la base de datos.
    // Si ocurre una excepción, el test falla y muestra un mensaje de error.
    @Test
    public void testCrearTabla() {
        try {
            ejercicio7_1.crearTabla();
            System.out.println("Test crearTabla: PASADO");
        } catch (SQLException | IOException e) {
            System.err.println("Test crearTabla: FALLADO");
            e.printStackTrace();
            fail("Excepción en testCrearTabla: " + e.getMessage());
        }
    }

    // Test para verificar la inserción de datos en la tabla.
    // Intenta ejecutar el método que inserta datos y muestra un mensaje si ocurre algún error.
    @Test
    public void testInsertarDatos() {
        try {
            ejercicio7_1.limpiarTabla();  // Eliminar datos previos de la tabla
            ejercicio7_1.insertarDatos();  // Insertar datos de prueba
            System.out.println("Test insertarDatos: PASADO");
        } catch (SQLException | IOException e) {
            System.err.println("Test insertarDatos: FALLADO");
            e.printStackTrace();
            fail("Excepción en testInsertarDatos: " + e.getMessage());
        }
    }

    // Test para verificar la modificación del estado de finalización de tareas.
    // Intenta cambiar el estado de tareas con IDs específicos a "finalizadas" (true).
    // Falla si ocurre una excepción durante la modificación.
    @Test
    public void testModificarFinalizacion() {
        try {
            ejercicio7_1.modificarFinalizacion(Arrays.asList(6, 7, 8), true);
            System.out.println("Test modificarFinalizacion: PASADO");
        } catch (SQLException e) {
            System.err.println("Test modificarFinalizacion: FALLADO");
            e.printStackTrace();
            fail("Excepción en testModificarFinalizacion: " + e.getMessage());
        }
    }

    // Test para verificar la consulta de tareas entre dos fechas específicas.
    // Este test ejecuta el método que consulta tareas dentro de un rango de fechas,
    // y falla si ocurre alguna excepción durante la consulta.
    @Test
    public void testConsultarEntreFechas() {
        try {
            ejercicio7_1.consultarEntreFechas(Date.valueOf("2024-01-01"), Date.valueOf("2024-12-31"));
            System.out.println("Test consultarEntreFechas: PASADO");
        } catch (SQLException e) {
            System.err.println("Test consultarEntreFechas: FALLADO");
            e.printStackTrace();
            fail("Excepción en testConsultarEntreFechas: " + e.getMessage());
        }
    }
    
    
}
