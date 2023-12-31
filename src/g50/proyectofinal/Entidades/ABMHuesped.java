/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.Entidades;

import g50.proyectofinal.AccesoADatos.ABMReserva;
import g50.proyectofinal.AccesoADatos.Conexion;
import g50.proyectofinal.AccesoADatos.TipoDeHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author whatu
 */
public class ABMHuesped {

    // s (nombre, DNI, Domicilio, correo, celular). 
    private String nombre;
    private int dni;
    private String domicilio;
    private String correo;
    private int celular;
    private Connection con = null;

    public ABMHuesped() {
        con = Conexion.getConexion();
    }

    public ABMHuesped(String nombre, int dni, String domicilio, String correo, int celular) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }



    @Override
    public String toString() {
        return  "Nombre=" + nombre + ", DNI=" + dni + ", Domicilio=" + domicilio + ", Correo=" + correo + ", Celular=" + celular ;
    }

  

}
