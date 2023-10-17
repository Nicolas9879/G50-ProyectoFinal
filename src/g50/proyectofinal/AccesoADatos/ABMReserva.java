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

    public ArrayList<Habitacion> CrearReserva(int personas) {
        int cod = 0;
        ArrayList<Habitacion> habarray = new ArrayList();
        String sql = "SELECT codigo FROM tipohabitaciones WHERE personasmaximas=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, personas);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cod = rs.getInt("codigo");
            }
            Habitacion hab = new Habitacion();

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
        return habarray;
    }

    public void crearReserva2(String nombre, int dni, String domi, String correo, String celular, int numerohab, int personas,
            Date fechasalida, Date fechaentrada, int monto) {  //DEBE CAMBIAR EL ESTADO DE LA HABITACION...A  PARTIR DE SU NUMERO.. ADEMAS DE CREAR LA RESERVA Y NO SOLO DEVOLVER UN ARRAY.. SERIA LA 2DA PARTE DEL M
        int idHuesped = 0;
        String sql = "INSERT INTO huesped (nombre, dni, domicilio, correo, celular) VALUES (?.?.?.?.?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            ps.setInt(2, dni);
            ps.setString(3, domi);
            ps.setString(4, correo);
            ps.setString(5, celular);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idHuesped = (rs.getInt("id_huesped"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }

        String sql2 = "INSERT INTO reserva (id_huesped, fecha_entrada, fecha_salida, importe_total, personas) VALUES (?, ?, ?,?,?)";
        try {
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, idHuesped);
            ps2.setDate(2, fechaentrada);
            ps2.setDate(3, fechasalida);
            ps2.setInt(4, monto);
            ps2.setInt(5, personas);
            ps2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reserva realizada con éxito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        String sql3 = "UPDATE  habitacion  SET precioxnoche=? WHERE numero=?";
        try {
            PreparedStatement ps3 = con.prepareStatement(sql3);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }

    public double calcularEstadia(TipoDeHabitacion tip, int dias) {
        double a = tip.getPrecioxnoche();
        return a * dias;
    }

    public void finReserva(ABMHuesped huesped) {
        String sql = "DELETE FROM reserva WHERE dni=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, huesped.getDni());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL FINALIZAR RESERVA");
        }
    }

    public ABMReserva buscaReserva(ABMHuesped huesped) {
        ABMReserva reserva = new ABMReserva();

        String sql = "SELECT * FROM reserva WHERE dni=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, huesped.getDni());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reserva.setCantidadpersonas(rs.getInt("personas"));
                reserva.setFechaentrada(rs.getDate("fecha_entrada").toLocalDate());
                reserva.setFechasalida(rs.getDate("fecha_salida").toLocalDate());
                reserva.setHuesped(huesped);
                reserva.setImportetotal(rs.getInt("importe_total"));
                reserva.setTipohabitacion(codigoHabitacion(rs.getInt("codigo")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR RESERVA");
        }
        return reserva;
    }

    public ABMReserva buscaReserva(LocalDate fecha_entrada) {
        ABMReserva reserva = new ABMReserva();

        String sql = "SELECT * FROM reserva WHERE dni=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, huesped.getDni());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reserva.setCantidadpersonas(rs.getInt("personas"));
                reserva.setFechaentrada(rs.getDate("fecha_entrada").toLocalDate());
                reserva.setFechasalida(rs.getDate("fecha_salida").toLocalDate());
                reserva.setHuesped(huesped);
                reserva.setImportetotal(rs.getInt("importe_total"));
                reserva.setTipohabitacion(codigoHabitacion(rs.getInt("codigo")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR RESERVA");
        }
        return reserva;
    }

    // Mostrar Habitaciones clasificadas por Tipo de Habitación, y su estado actual (Libre/Ocupada).
    public void mostrarHabitacion(TipoDeHabitacion tip) {

        ArrayList<Habitacion> habs = new ArrayList();

        String sql = "SELECT * FROM habitaciones WHERE codigo=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tip.getCodigo()); // revisa el codigo...asociado al tipo de habitacion
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Habitacion hab = null;
                hab.setNumero(rs.getInt("numero"));
                hab.setCodigo(rs.getInt("codigo"));
                hab.setEstado(rs.getBoolean("estado"));
                habs.add(hab);
            }

            for (Habitacion browser : habs) {
                System.out.println(browser);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR RESERVA");
        }
    }

    public void informeHuespedes(int dni) {
        ArrayList<ABMHuesped> huespeds = new ArrayList();
        String sql = "SELECT * FROM reserva WHERE dni=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, huesped.getDni());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ABMHuesped huesped1 = null;
                huesped1.setCelular(rs.getInt("celular"));
                huesped1.setCorreo(rs.getString("correo"));
                huesped1.setDni(rs.getInt("dni"));
                huesped1.setDomicilio(rs.getString("domicilio"));
                huesped1.setNombre(rs.getString("nombre"));
                huespeds.add(huesped1);
            }
            for (ABMHuesped browser : huespeds) {
                System.out.println(browser); //DEBERIA CONVERTIRLO EN UN JOPTION PANE? // PERO COMO PODRIA CREAR UNA TABLA DE LA NADA?
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR RESERVA");
        }
    }
    //Un informe de Huespedes por dni como campo de búsqueda.
    // METODO EXTRA <<<<<// METODO EXTRA <<<<<// METODO EXTRA <<<<<

    public TipoDeHabitacion codigoHabitacion(int cod) {
        TipoDeHabitacion tp = new TipoDeHabitacion();
        String sql = "SELECT * FROM tipohabitaciones WHERE codigo=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cod);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tp.setCamas(rs.getInt("camas"));
                tp.setCodigo(cod);
                tp.setPersonasmaximas(rs.getInt("personasmaximas"));
                tp.setPrecioxnoche(rs.getInt("precioxnoche"));
                tp.setTipocama(rs.getString("tipocama"));
                tp.setTipohabitacion(rs.getString("tipohabitacion"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR RESERVA");
        }
        return tp;
    }
// METODO EXTRA <<<<<// METODO EXTRA <<<<<// METODO EXTRA <<<<<// METODO EXTRA <<<<<
//    public ABMReserva buscaReserva(LocalDate fechaentrada) {
//        
//    }
}
