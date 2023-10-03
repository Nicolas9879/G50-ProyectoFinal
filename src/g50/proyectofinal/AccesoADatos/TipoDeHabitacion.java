/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.AccesoADatos;

/**
 *
 * @author whatu
 */
public class TipoDeHabitacion {

////    Crear la Clase Tipo de Habitación tendrá sus propias características, las relevantes para nuestro sistema de
//    gestión de reservas son: código, cantidad de personas (maxima), cantidad de camas, tipo de camas (Simples, Queen, King Size), 
//            precio por noche, que por simplicidad se supondrá único (sin promociones o tarifas distintas para temporada alta o baja). 
////Un método cambiarPrecio, busca un Tipo de Habitación y actualiza su precio.
    private int codigo;
    private int personasmaximas;
    private int camas;
    private String tipocama;
    private int precioxnoche;
    private boolean estado; // esto deberia existir?

    public TipoDeHabitacion(int codigo, int personasmaximas, int camas, String tipocama, int precioxnoche, boolean estado) {
        this.codigo = codigo;
        this.personasmaximas = personasmaximas;
        this.camas = camas;
        this.tipocama = tipocama;
        this.precioxnoche = precioxnoche;
        this.estado = estado;
    }

    
  
    public TipoDeHabitacion() {
    }

    
    
    private void cambiarPrecio() {
        // BUSCA UN TIPO DE HABITACION Y ACTUALIZA SU PRECIO
    }

}
