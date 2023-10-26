/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.AccesoADatos;

import java.sql.PreparedStatement;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author whatu
 */
public class TipoDeHabitacion {

////    Crear la Clase Tipo de Habitación tendrá sus propias características, las relevantes para nuestro sistema de
//    gestión de reservas son: código, cantidad de personas (maxima), cantidad de camas, tipo de camas (Simples, Queen, King Size), 
//            precio por noche, que por simplicidad se supondrá único (sin promociones o tarifas distintas para temporada alta o baja). 
////Un método cambiarPrecio, busca un Tipo de Habitación y actualiza su precio.
    private int codigo;
    private int personasmaximas;
    private int camas;
    private String tipocama;
    private double precioxnoche;

    private String tipohabitacion; //Estándar simple, doble, Triple, o Suite Lujo
    private Connection con;

    public TipoDeHabitacion(int personasmaximas, int camas, String tipocama, double precioxnoche, String tipohabitacion) {

        this.personasmaximas = personasmaximas;
        this.camas = camas;
        this.tipocama = tipocama;
        this.precioxnoche = precioxnoche;
        this.tipohabitacion = tipohabitacion;
    }

    public TipoDeHabitacion() {
        con = Conexion.getConexion();//necesario
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPersonasmaximas() {
        return personasmaximas;
    }

    public void setPersonasmaximas(int personasmaximas) {
        this.personasmaximas = personasmaximas;
    }

    public int getCamas() {
        return camas;
    }

    public void setCamas(int camas) {
        this.camas = camas;
    }

    public String getTipocama() {
        return tipocama;
    }

    public void setTipocama(String tipocama) {
        this.tipocama = tipocama;
    }

    public double getPrecioxnoche() {
        return precioxnoche;
    }

    public void setPrecioxnoche(double precioxnoche) {
        this.precioxnoche = precioxnoche;
    }

    public String getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public void cambiarPrecio(String tipohabitacion, double precio) {
        // BUSCA UN TIPO DE HABITACION Y ACTUALIZA SU PRECIO
        String sql = "UPDATE  tipohabitaciones  SET precioxnoche=? WHERE tipohabitacion=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, precio);
            ps.setString(2, tipohabitacion);

            int rowsaffected = ps.executeUpdate();

            if (rowsaffected > 0) {
                JOptionPane.showMessageDialog(null, "Precio actualizado con exito");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cambiar precio");
        }

    }

    @Override
    public String toString() {
        return "TipoDeHabitacion{" + "codigo=" + codigo + ", personasmaximas=" + personasmaximas + ", camas=" + camas + ", tipocama=" + tipocama + ", precioxnoche=" + precioxnoche + ", tipohabitacion=" + tipohabitacion + '}';
    }

}
