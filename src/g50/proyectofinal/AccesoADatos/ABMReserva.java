/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.AccesoADatos;

import g50.proyectofinal.Entidades.ABMHuesped;
import java.time.LocalDate;
import java.util.List;

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

    public ABMReserva() {
    }

    public ABMReserva(ABMHuesped huesped, TipoDeHabitacion tipohabitacion, int cantidadpersonas, LocalDate fechaentrada, LocalDate fechasalida, int importetotal) {
        this.huesped = huesped;
        this.tipohabitacion = tipohabitacion;
        this.cantidadpersonas = cantidadpersonas;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.importetotal = importetotal;
    }

    
    
    
    
    private List<TipoDeHabitacion> CrearReserva() {
        
    }

    private int calcularEstadia(){
        
    }
    
    private void finReserva(){
        
    }
    private ABMReserva(ABMHuesped huesped){
        
    }
    
    
    
}
