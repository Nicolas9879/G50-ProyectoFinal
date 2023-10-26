/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.Entidades;

import g50.proyectofinal.AccesoADatos.Conexion;
import g50.proyectofinal.AccesoADatos.TipoDeHabitacion;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Habitacion {

    private int numero;
    private int piso;
    private boolean estado;
    private TipoDeHabitacion tipohabitacion;
    private String tipo;
    private int codigo;
    private Connection con;
    private LocalDate fechasalida;

    public Habitacion(int numero, String tipo, int piso, boolean estado, TipoDeHabitacion tipohabitacion) {
        this.numero = numero;
        this.piso = piso;
        this.piso = piso;
        this.estado = estado;
        this.tipohabitacion = tipohabitacion;
    }

    public Habitacion() {
        con = Conexion.getConexion();//necesario
    }

    public Habitacion(int codigo) {
        this.codigo = codigo;

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTipohabitacion(TipoDeHabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "numero=" + numero + ", estado=" + estado + ", tipohabitacion=" + tipohabitacion + '}';
    }

}
