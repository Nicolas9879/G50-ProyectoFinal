/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.Entidades;

import g50.proyectofinal.AccesoADatos.TipoDeHabitacion;

/**
 *
 * @author whatu
 */
public class Habitacion {

    private int codigo;
    private int numero;
    private boolean estado;
    private TipoDeHabitacion tipohabitacion;

    public Habitacion(int codigo, boolean estado, TipoDeHabitacion tipohabitacion) {
        this.codigo = codigo;

        this.estado = estado;
        this.tipohabitacion = tipohabitacion;
    }

    public TipoDeHabitacion getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(TipoDeHabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public Habitacion() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    @Override
    public String toString() {
        return "Habitacion{" + "codigo=" + codigo + ", numero=" + numero + ", estado=" + estado + ", tipohabitacion=" + tipohabitacion + '}';
    }

}
