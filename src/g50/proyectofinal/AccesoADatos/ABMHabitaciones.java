/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.AccesoADatos;

import g50.proyectofinal.Entidades.Habitacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        String sql = "INSERT INTO habitaciones ( numero, codigo, estado, piso) VALUES (?,?, ?, ?)";

// Preparar la consulta y establecer los valores para el nuevo tipo de habitación
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, habit.getNumero());
            ps.setInt(2, habit.getTipohabitacion().getCodigo());
            ps.setBoolean(3, habit.isEstado());
            ps.setInt(4, habit.getPiso());

// Ejecutar la consulta para agregar el nuevo tipo de habitación
            ps.executeUpdate();

//            JOptionPane.showMessageDialog(null, "Habitacion dada de alta con éxito");
            System.out.println("Habitacion Habilitada");
        } catch (SQLException ex) {
            System.out.println("ERROR");
        }

    }

    public ArrayList habitacionesDisponibles() {
        ABMReserva ar = new ABMReserva();
        ArrayList<Habitacion> habarray = new ArrayList();

        Habitacion hab = new Habitacion();

        String sql2 = "SELECT numero, estado, piso, codigo FROM habitaciones";

        try {
            PreparedStatement ps2 = con.prepareStatement(sql2, PreparedStatement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {

                hab.setNumero(rs.getInt("numero"));
                hab.setEstado(rs.getBoolean("estado"));
                hab.setPiso(rs.getInt("piso"));
                hab.setTipo(ar.codigoHabitacion(rs.getInt("codigo")).getTipohabitacion());
                habarray.add(hab);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar  habitaciones");
        }
        return habarray;
    }

    /*   public void nuevoTipo(TipoDeHabitacion tip) {
        String sql = "INSERT INTO tipohabitaciones (precioxnoche,camas,personasmaximas,tipocama, tipohabitacion) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, tip.getPrecioxnoche());
            ps.setInt(2, tip.getCamas());
            ps.setInt(3, tip.getPersonasmaximas());
            ps.setString(4, tip.getTipocama());
            ps.setString(5, tip.getTipohabitacion());
// Ejecutar la consulta para agregar el nuevo tipo de habitación
            int a = ps.executeUpdate();

            System.out.println(a);
            JOptionPane.showMessageDialog(null, "Nuevo Tipo De Habitacion añadido");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al añadir nuevo tipo de habitacion");
            String errorMessage = ex.getMessage();
            JOptionPane.showMessageDialog(null, "Error: " + errorMessage);
        }*/
}
