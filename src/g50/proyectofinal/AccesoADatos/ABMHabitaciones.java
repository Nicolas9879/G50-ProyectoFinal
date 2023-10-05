/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.AccesoADatos;

import g50.proyectofinal.Entidades.Habitacion;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author whatu
 */
public class ABMHabitaciones {
//    ABM de Habitaciones: Se deben poder gestionar el alta baja y modificación de Habitaciones de un tipo. Ejemplo.
//            Si antes tenía 30 de tipo estándar, luego de agregar las habitaciones 201 al 205 de ese tipo, el conteo sumará 35 en total.

    //-- Comentarios-- >> Seria un CRUD? un metodo para el Create (alta), otro para el Read, otro para el delete y uno al final para el update.
    // Deberia  de crearse en la base de datos.
    // añadir habitaciones
    private Connection con = null;

    public ABMHabitaciones() {
        con = Conexion.getConexion();//necesario
    }

    public void altaHabitacion(Habitacion habit) {

        String sql = "INSERT INTO habitacion (numero, estado, tipohabitacion) VALUES (?, ?, ?)";

// Preparar la consulta y establecer los valores para el nuevo tipo de habitación
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, habit.getNumero());
            ps.setBoolean(2, habit.isEstado());
            ps.setString(3, habit.getTipohabitacion().getTipohabitacion());

// Ejecutar la consulta para agregar el nuevo tipo de habitación
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Habitacion dada de alta con éxito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo al dar de alta habitación");
        }

    }

}
