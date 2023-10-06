/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.Entidades;

import g50.proyectofinal.AccesoADatos.Conexion;
import g50.proyectofinal.AccesoADatos.TipoDeHabitacion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Habitacion {

    private int numero;
    private boolean estado;
    private TipoDeHabitacion tipohabitacion;
    private int codigo;
    private Connection con;

    public Habitacion(int numero, boolean estado, TipoDeHabitacion tipohabitacion) {
        this.numero = numero;
        this.estado = estado;
        this.tipohabitacion = tipohabitacion;
    }

    public Habitacion() {
        con = Conexion.getConexion();//necesario
    }

    public Habitacion(int codigo) {
        this.codigo = codigo;

        switch (codigo) {

            case 1:
                // Code to execute if expression equals value1
                break; // Optional: Use 'break' to exit the switch block

            case 2:
                // Code to execute if expression equals value2

                break;

            // Add more cases as needed
            default:
            // Code to execute if none of the cases match the expression
        }

    }

    public tipoHabitacion AsignarCodigo(int cod) {
        String sql = "SELECT * FROM tipohabitaciones WHERE cod=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            
            ResultSet rs= ps.getGeneratedKeys();
            while(rs.next()){
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error 12");
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoDeHabitacion getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(TipoDeHabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "numero=" + numero + ", estado=" + estado + ", tipohabitacion=" + tipohabitacion + '}';
    }

}
