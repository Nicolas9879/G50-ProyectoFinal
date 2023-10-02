/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g50.proyectofinal.Entidades;

/**
 *
 * @author whatu
 */
public class ABMHuesped {
    
    
    // s (nombre, DNI, Domicilio, correo, celular). 
    
    private String nombre;
    private int  dni;
    private String domicilio;
    private String correo;
    private int celular;

    public ABMHuesped() {
    }

    public ABMHuesped(String nombre, int dni, String domicilio, String correo, int celular) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
        this.celular = celular;
    }
    
    
    
    
}
