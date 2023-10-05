/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.AccesoADatos;

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

    public void altaHabitacion(TipoDeHabitacion habit) {
        TipoDeHabitacion hab1 = new TipoDeHabitacion(habit.getPersonasmaximas(), habit.getCamas(),
                habit.getTipocama(), habit.getPrecioxnoche(), habit.isEstado(), habit.getTipohabitacion());

        String sql = "INSERT INTO tipohabitacion AND habitacion (tipo_habitacion, estado, precioxnoche, camas, personasmaximas, tipocama) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

// Preparar la consulta y establecer los valores para el nuevo tipo de habitación
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, habit.getTipohabitacion());
            ps.setBoolean(2, habit.isEstado());  // Cantidad máxima de personas
            ps.setDouble(3, habit.getPrecioxnoche());  // Cantidad de camas
            ps.setInt(4, habit.getCamas());  // Tipo de camas
            ps.setInt(5, habit.getPersonasmaximas());  // Precio por noche
            ps.setString(6, habit.getTipocama());  // Precio por noche

// Ejecutar la consulta para agregar el nuevo tipo de habitación
            ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo al dar de alta habitación");
        }
    }


}


