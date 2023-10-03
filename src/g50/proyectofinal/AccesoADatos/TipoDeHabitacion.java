/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.AccesoADatos;

import java.sql.PreparedStatement;

import java.sql.*;

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
    private int precioxnoche;
    private boolean estado; // esto deberia existir?
    private String tipohabitacion; //Estándar simple, doble, Triple, o Suite Lujo
    private Connection con = null;

    public TipoDeHabitacion(int codigo, int personasmaximas, int camas, String tipocama, int precioxnoche, boolean estado, String tipohabitacion) {
        this.codigo = codigo;
        this.personasmaximas = personasmaximas;
        this.camas = camas;
        this.tipocama = tipocama;
        this.precioxnoche = precioxnoche;
        this.estado = estado;
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

    public int getPrecioxnoche() {
        return precioxnoche;
    }

    public void setPrecioxnoche(int precioxnoche) {
        this.precioxnoche = precioxnoche;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    private void cambiarPrecio(String tipohabitacion) {
        // BUSCA UN TIPO DE HABITACION Y ACTUALIZA SU PRECIO
        String sql = "SELECT * FROM tipohabitacion WHERE tipohabitacion=?";

        PreparedStatement ps = con.                       
                
    }

}
