/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.AccesoADatos;

import g50.proyectofinal.Entidades.ABMHuesped;
import g50.proyectofinal.Entidades.Habitacion;
import java.time.LocalDate;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author whatu
 */
public class ABMReserva {
////    ABM Reserva. En cada Reserva se toma nota de: datos del Huesped, Tipo de Habitación, cantidad de personas, fechas de entrada y 
//    salida, importe total de estadía. Metodos Buscar una Reserva por Huesped, Cancelar reserva
//
//
//El proceso de hacer una Reserva se organizará. El método Crear Reserva:
//Se introduce por teclado fechaEntrada y fechaSalida y cantidad de personas.
//Se busca un “tipo de habitación” para esa cantidad de personas y el precio. 
//Se devuelve una lista de las habitaciones que estén Libres, de ese “Tipo Habitación”.
//
//    
//    
//Calcular monto estadía:  en la reserva, se calcula como precio por noche (de Tipo Habitación) por cantidad de días de estadía ingresado. Devuelve el monto*.
//Se construye la reserva con fechaCheckin, fechaCheckout, Huesped, Habitacion, monto*, estado=1.
//La Habitación se marca Ocupada(1), en la fecha de salida vuelve a su estado Libre.
//
//Método “finReserva” recibe un Hueped, permite buscar una reserva se marca, de Activa(1) a Inactiva(0). Se busca la habitación y se marca Libre(0). 
//
//Búsqueda de Reservas por Huésped o fechas: devuelve una Reserva.
//Mostrar Habitaciones clasificadas por Tipo de Habitación, y su estado actual (Libre/Ocupada).
//Un informe de Huespedes por dni como campo de búsqueda.
//

    private ABMHuesped huesped;
    private TipoDeHabitacion tipohabitacion;
    private int cantidadpersonas;
    private LocalDate fechaentrada;
    private LocalDate fechasalida;
    private int importetotal;
    private Connection con = null;
    
    public ABMReserva() {
        con = Conexion.getConexion();
    }
    
    public ABMReserva(ABMHuesped huesped, TipoDeHabitacion tipohabitacion, int cantidadpersonas, LocalDate fechaentrada, LocalDate fechasalida, int importetotal) {
        this.huesped = huesped;
        this.tipohabitacion = tipohabitacion;
        this.cantidadpersonas = cantidadpersonas;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.importetotal = importetotal;
    }
    
    public ABMHuesped getHuesped() {
        return huesped;
    }
    
    public void setHuesped(ABMHuesped huesped) {
        this.huesped = huesped;
    }
    
    public TipoDeHabitacion getTipohabitacion() {
        return tipohabitacion;
    }
    
    public void setTipohabitacion(TipoDeHabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }
    
    public int getCantidadpersonas() {
        return cantidadpersonas;
    }
    
    public void setCantidadpersonas(int cantidadpersonas) {
        this.cantidadpersonas = cantidadpersonas;
    }
    
    public LocalDate getFechaentrada() {
        return fechaentrada;
    }
    
    public void setFechaentrada(LocalDate fechaentrada) {
        this.fechaentrada = fechaentrada;
    }
    
    public LocalDate getFechasalida() {
        return fechasalida;
    }
    
    public void setFechasalida(LocalDate fechasalida) {
        this.fechasalida = fechasalida;
    }
    
    public int getImportetotal() {
        return importetotal;
    }
    
    public void setImportetotal(int importetotal) {
        this.importetotal = importetotal;
    }
    
    public ArrayList<Habitacion> CrearReserva(LocalDate entrada, LocalDate salida, int personas) {
        int cod = 0;
        String sql = "SELECT codigo FROM tipohabitaciones WHERE personasmaximas=? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, personas);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cod = rs.getInt("codigo");
            }
            Habitacion hab = new Habitacion();
            ArrayList<Habitacion> habarray = new ArrayList();
            String sql2 = "SELECT numero, estado FROM habitaciones WHERE codigo=?";
            PreparedStatement ps2 = con.prepareStatement(sql2, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cod);
            ResultSet rs2 = ps2.executeQuery();
            while (rs.next()) {
               
                hab.setNumero(rs.getInt("numero"));
                hab.setEstado(rs.getBoolean("estado"));
                habarray.add(hab);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar tipos de habitacion");
        }
        
    }
//
//    private int calcularEstadia(){
//        //
//    }
//    
//    private void finReserva(){
//        //
//    }
//    private ABMReserva(ABMHuesped huesped){
//        //
//    }

}
