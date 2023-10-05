/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.AccesoADatos;

/**
 *
 * @author whatu
 */
public class ABMHabitaciones {
//    ABM de Habitaciones: Se deben poder gestionar el alta baja y modificación de Habitaciones de un tipo. Ejemplo.
//            Si antes tenía 30 de tipo estándar, luego de agregar las habitaciones 201 al 205 de ese tipo, el conteo sumará 35 en total.

    //-- Comentarios-- >> Seria un CRUD? un metodo para el Create (alta), otro para el Read, otro para el delete y uno al final para el update.
    // Deberia  de crearse en la base de datos.
    // añadir habitaciones
    public void altaHabitacion(TipoDeHabitacion habit) {
        TipoDeHabitacion hab1 = new TipoDeHabitacion(habit.getPersonasmaximas(), habit.getCamas(),
                habit.getTipocama(), habit.getPrecioxnoche(), habit.isEstado(), habit.getTipohabitacion());

        String sql="INSERT INTO "
        
        
    }

}
