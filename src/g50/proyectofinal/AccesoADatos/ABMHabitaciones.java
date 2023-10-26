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

        String sql = "INSERT INTO habitacion (tipohabitacion, numero, estado) VALUES (?, ?, ?)";

// Preparar la consulta y establecer los valores para el nuevo tipo de habitación
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, habit.getTipohabitacion().getTipohabitacion());
            ps.setInt(2, habit.getNumero());
            ps.setBoolean(3, habit.isEstado());

// Ejecutar la consulta para agregar el nuevo tipo de habitación
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Habitacion dada de alta con éxito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo al dar de alta habitación");
        }

    }

    public void habitacionesDisponibles(){
        
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
