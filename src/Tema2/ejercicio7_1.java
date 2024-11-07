package Tema2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ejercicio7_1 {

    private static String connectionString;
    private static String dbUser;
    private static String dbPassword;
    private static String createScriptPath;
    private static String insertScriptPath;

    // Este método carga las configuraciones desde el archivo bd.config,
    // leyendo propiedades como la conexión a la base de datos, el usuario,
    // la contraseña y las rutas de los scripts para crear e insertar datos en la tabla.
    public static void cargarConfiguracion(String configFilePath) {
        Properties properties = new Properties();
        try (FileInputStream FiS = new FileInputStream(configFilePath)) {
            properties.load(FiS);
            connectionString = properties.getProperty("conexion");
            dbUser = properties.getProperty("usuario");
            dbPassword = properties.getProperty("contraseña");
            createScriptPath = properties.getProperty("ruta_script_creacion");
            insertScriptPath = properties.getProperty("ruta_script_insercion");
            System.out.println("Configuración cargada correctamente.");
        } catch (IOException e) {
            System.err.println("Error al cargar la configuración: " + e.getMessage());
        }
    }

    // Este método se conecta a la base de datos usando los datos cargados,
    // lee el contenido del archivo de creación de la tabla y ejecuta el script SQL
    // para crear la tabla 'tareas' en la base de datos.
    public static void crearTabla() throws SQLException, IOException {
        try (Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPassword);
             Statement stmt = conn.createStatement()) {
            String createScript = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(createScriptPath)));
            stmt.execute(createScript);
            System.out.println("Tabla 'tareas' creada correctamente.");
        }
    }

    // Este método se conecta a la base de datos y lee el archivo de inserción de datos.
    // Lee cada línea del archivo y ejecuta cada línea como una instrucción SQL,
    // insertando los datos en la tabla 'tareas'.
    public static void insertarDatos() throws SQLException, IOException {
        try (Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPassword);
             Statement stmt = conn.createStatement();
             BufferedReader reader = new BufferedReader(new FileReader(insertScriptPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Elimina espacios en blanco al inicio y al final de cada línea.
                if (!line.isEmpty()) { // Verifica si la línea no está vacía antes de ejecutarla.
                    stmt.execute(line); // Ejecuta la línea como instrucción SQL.
                }
            }
            System.out.println("Datos insertados correctamente en la tabla 'tareas'.");
        }
    }

    // Este método modifica el estado de finalización de las tareas con IDs específicos.
    // Recibe una lista de IDs y un valor booleano para indicar si están finalizadas.
    // Usa una consulta preparada para cambiar el estado 'finalizada' en la tabla.
    public static void modificarFinalizacion(List<Integer> ids, boolean finalizada) throws SQLException {
        String query = "UPDATE tareas SET finalizada = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            for (Integer id : ids) {
                pstmt.setBoolean(1, finalizada); // Establece el valor de 'finalizada' (true o false).
                pstmt.setInt(2, id); // Establece el ID de la tarea a actualizar.
                pstmt.executeUpdate(); // Ejecuta la actualización en la base de datos.
            }
            
            System.out.println("Estado de finalización actualizado para los IDs: " + ids);
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;  // Re-lanzar la excepción
        }
    }

    // Este método consulta tareas dentro de un rango de fechas en la tabla.
    // Recibe una fecha de inicio y una de finalización como parámetros.
    // Muestra los resultados con los detalles de cada tarea dentro del rango.
    public static void consultarEntreFechas(Date fechaInicio, Date fechaFin) throws SQLException {
        String query = "SELECT * FROM tareas WHERE fecha_inicio >= ? AND fecha_final <= ?";
        try (Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDate(1, fechaInicio); // Establece el parámetro de fecha de inicio en la consulta.
            pstmt.setDate(2, fechaFin); // Establece el parámetro de fecha de finalización en la consulta.
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) { // Itera sobre los resultados y muestra los datos de cada tarea.
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Descripción: " + rs.getString("descripcion"));
                System.out.println("Fecha Inicio: " + rs.getDate("fecha_inicio"));
                System.out.println("Fecha Final: " + rs.getDate("fecha_final"));
                System.out.println("Finalizada: " + rs.getBoolean("finalizada"));
                System.out.println();
            }
        }
    }
    
    public static void limpiarTabla() throws SQLException {
        String query = "DELETE FROM tareas";  // Asegúrate de usar el nombre correcto de la tabla
        try (Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPassword);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        }
    }
}
