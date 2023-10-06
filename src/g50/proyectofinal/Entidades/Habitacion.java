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

    private int numero;
    private boolean estado;
    private TipoDeHabitacion tipohabitacion;

    public Habitacion(int numero, boolean estado, TipoDeHabitacion tipohabitacion) {
        this.numero = numero;
        this.estado = estado;
        this.tipohabitacion = tipohabitacion;
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
