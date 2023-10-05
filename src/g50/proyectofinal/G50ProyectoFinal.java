/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package g50.proyectofinal;

import g50.proyectofinal.AccesoADatos.ABMHabitaciones;
import g50.proyectofinal.AccesoADatos.TipoDeHabitacion;

public class G50ProyectoFinal {

    
 
    public static void main(String[] args) {
        // TODO code application logic here
        
        TipoDeHabitacion tp=new TipoDeHabitacion(4, 4, "King Size", 15700, true, "Suite");
        ABMHabitaciones ab=new ABMHabitaciones();
        ab.altaHabitacion(tp);
        System.out.println(tp);
    }
    
}
