/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author whatu
 */
public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost/"; //URL DEL SERVIDOR DE MARIADB INCLUYE PROTOCOLO
    private static final String DB = "g50-proyectofinal"; //nombre asignado a la base de datos
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    private Conexion() {
    }

    public static Connection getConexion() {
        if (connection == null) {

            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL CARGAR DRIVERS");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR A BASE DE DATOS");
            }

        }
        return connection;
    }
}


