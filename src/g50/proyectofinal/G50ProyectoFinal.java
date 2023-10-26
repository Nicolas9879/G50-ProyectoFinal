/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package g50.proyectofinal;

import g50.proyectofinal.AccesoADatos.*;
import g50.proyectofinal.Entidades.Habitacion;

public class G50ProyectoFinal {

    public static void main(String[] args) {

        ABMReserva ar = new ABMReserva();
        TipoDeHabitacion th = ar.codigoHabitacion(1);
        ABMHabitaciones ab = new ABMHabitaciones();
        for (int i = 2; i < 100; i++) {
            Habitacion habit = new Habitacion(i, th.getTipohabitacion(), 1, true, th);

            ab.altaHabitacion(habit);
        }
    }

}
