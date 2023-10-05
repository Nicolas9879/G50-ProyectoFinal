/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package g50.proyectofinal;

import g50.proyectofinal.AccesoADatos.ABMHabitaciones;
import g50.proyectofinal.AccesoADatos.TipoDeHabitacion;
import g50.proyectofinal.Entidades.Habitacion;

public class G50ProyectoFinal {

    public static void main(String[] args) {
        // TODO code application logic here
        ///////---TEST 1-------------////     ///////---TEST 1-------------////     ///////---TEST 1-------------////     ///////---TEST 1-------------////     ///////---TEST 1-------------////
        TipoDeHabitacion prueba= new TipoDeHabitacion(20, 20, "King Size", 70500, "Suite");
        Habitacion tp = new Habitacion(13, true, prueba); // ENUM
        ABMHabitaciones ab = new ABMHabitaciones();
        ab.altaHabitacion(tp);
        System.out.println(tp);
        ///////---TEST 1-------------////        ///////---TEST 1-------------////        ///////---TEST 1-------------////        ///////---TEST 1-------------////        ///////---TEST 1-------------////
    }

}
