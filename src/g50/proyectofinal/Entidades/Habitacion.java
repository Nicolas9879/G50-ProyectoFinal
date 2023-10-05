/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.Entidades;

/**
 *
 * @author whatu
 */
public class Habitacion {

    private int codigo;
    private int numero;
    private boolean estado;
    private String tipohabitacion;

    public Habitacion(int numero, boolean estado, String tipohabitacion) {
        this.estado = estado;
        this.tipohabitacion = tipohabitacion;
        this.numero=numero;
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

    public String getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "codigo=" + codigo + ", numero=" + numero + ", estado=" + estado + ", tipohabitacion=" + tipohabitacion + '}';
    }

}
