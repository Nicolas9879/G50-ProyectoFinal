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
import java.time.temporal.ChronoUnit;
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
    private int numerohab;
    private int dni; // el id de huesped es su dni.
    private TipoDeHabitacion tipohabitacion;
    private int cantidadpersonas;
    private LocalDate fechaentrada;
    private LocalDate fechasalida;
    private int importetotal;
    private int piso;
    private Connection con = null;
    private int cod;

    public ABMReserva() {
        con = Conexion.getConexion();
    }

    public ABMReserva(ABMHuesped huesped, TipoDeHabitacion tipohabitacion, int cantidadpersonas, LocalDate fechaentrada, LocalDate fechasalida, int importetotal, int piso, int dni, int numerohab) {
        this.huesped = huesped;
        this.tipohabitacion = tipohabitacion;
        this.cantidadpersonas = cantidadpersonas;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.importetotal = importetotal;
        this.piso = piso;
    }

    public ABMHuesped getHuesped() {
        return huesped; // es necesario?
    }

    public void setHuesped(ABMHuesped huesped) {
        this.huesped = huesped;
    }

    public int getNumerohab() {
        return numerohab;
    }

    public void setNumerohab(int numerohab) {
        this.numerohab = numerohab;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public TipoDeHabitacion getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(TipoDeHabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
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

    public ArrayList<Habitacion> codigoHab(int personas) {
        cod = 0;
        String sql = "SELECT codigo FROM tipohabitaciones WHERE personasmaximas=? ";
        ArrayList<Habitacion> habarray = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, personas);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cod = rs.getInt("codigo");
                rs.close();
            }
            habarray = CrearReserva(cod);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER CODIGO");
        }
        return habarray;
    }

    public ArrayList<Habitacion> CrearReserva(int codigo) {   // pRIMER METODO provee de una lista de habitaciones que cumplen lo pedido n de personas
        ArrayList<Habitacion> habarray = new ArrayList();
        ABMReserva ab = new ABMReserva();
        String sql = "SELECT numero, estado, piso FROM habitaciones WHERE codigo=? AND estado=0";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Habitacion hab = new Habitacion();
                hab.setNumero(rs.getInt("numero"));
                hab.setEstado(rs.getBoolean("estado"));
                hab.setPiso(rs.getInt("piso"));
                hab.setTipo(((ab.codigoHabitacion(codigo)).getTipohabitacion()));
                hab.setCodigo(codigo);
                habarray.add(hab);

            }

        } // EL PRIMER METODO DEVUELVE UNA TABLA CON LAS HABITACIONES QUE CUMPLEN LOS REQUISITOS
        catch (SQLException ex) {
            Logger.getLogger(ABMReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return habarray;
    }

    public void crearReserva2(String nombre, int dni, String domi, String correo, String celular, int numerohab, int piso, int personas, int codigo,
            Date fechasalida, Date fechaentrada) {  //DEBE CAMBIAR EL ESTADO DE LA HABITACION...A  PARTIR DE SU NUMERO.. ADEMAS DE CREAR LA RESERVA Y NO SOLO DEVOLVER UN ARRAY.. SERIA LA 2DA PARTE DEL M
        ABMReserva ar = new ABMReserva();

        TipoDeHabitacion tp = ar.codigoHabitacion(codigo);
// AHORA FALTA CALCULAR LA DIFERENCIA DE DIAS PARA USAR EL METODO CALCULAR ESTADIA
// UTILIZO CHRONOUNIT para lograrlo.

        int days = (int) ChronoUnit.DAYS.between(fechaentrada.toLocalDate(), fechasalida.toLocalDate());
/// AHORA PUEDO INVOCAR EL METODO Y CALCULAR EL MONTO DE LA ESTADIA

        String sql = "INSERT INTO huesped (nombre, dni , domicilio, correo, celular) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            ps.setInt(2, dni);
            ps.setString(3, domi);
            ps.setString(4, correo);
            ps.setString(5, celular);

            ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR HUESPED");
            ex.printStackTrace();
        }

        String sql2 = "INSERT INTO reserva (dni, fecha_entrada, fecha_salida, importe_total, personas,numero,piso) VALUES (?, ?, ?,?,?,?,?)";
        try {
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, dni);
            ps2.setDate(2, fechaentrada);
            ps2.setDate(3, fechasalida);
            ps2.setDouble(4, ar.calcularEstadia(tp, days));  //Calculo el costo de la estadia y lo envio

            ps2.setInt(5, personas);
            ps2.setInt(6, numerohab);
            ps2.setInt(7, piso);
            ps2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reserva realizada con éxito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        String sql3 = "UPDATE habitaciones  SET estado=? where numero=?";     // MARCA HABITACION COMO OCUPADA
        try {
            PreparedStatement ps3 = con.prepareStatement(sql3);
            ps3.setBoolean(1, true);
            ps3.setInt(2, numerohab);
            ps3.executeUpdate();
            ps3.close();
            JOptionPane.showMessageDialog(null, "NºHabitacion: " + numerohab);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }

        //La Habitación se marca Ocupada(1), en la fecha de salida vuelve a su estado Libre.
// ES NECESARIO USAR QUARTZ... LO CUAL NO ES ENSEÑADO EN LA CURSADA... y no tengo idea de como usarlo. por ahora se finaliza la reserva con el metodo ese y ya.
    }

    public double calcularEstadia(TipoDeHabitacion tip, int dias) {
        double a = tip.getPrecioxnoche();
        return a * (double) dias;
    }

    public void finReserva(int dni) {
        /// Busca el numero de la habitacion reservada
        int number = 0;
        String sql4 = "SELECT numero FROM reserva WHERE dni=?";
        try {
            PreparedStatement ps4 = con.prepareStatement(sql4);
            ps4.setInt(1, dni);
            ResultSet rs = ps4.executeQuery();
            while (rs.next()) {
                number = rs.getInt("numero");
            }

            ps4.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR NUMERO");
            ex.printStackTrace();
        }

        //
        String sql3 = "UPDATE habitaciones  SET estado=? where numero=?";

        try {
            PreparedStatement ps3 = con.prepareStatement(sql3);
            ps3.setBoolean(1, false);
            ps3.setInt(2, number);
            ps3.executeUpdate();
            ps3.close();
            JOptionPane.showMessageDialog(null, "La habitacion " + number + " ha sido liberada.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL LIBERAR HABITACION");
        }

        String sql = "DELETE FROM reserva WHERE dni=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Reserva eliminada con Exito!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL FINALIZAR RESERVA");
        }
        String sql2 = "DELETE FROM huesped WHERE dni=?";
        try {
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, dni);
            ps2.executeUpdate();
            ps2.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR HUESPED");
        }

    }

    public ArrayList<ABMReserva> buscaReserva(int dni) {
        ArrayList<ABMReserva> arrayReservas = new ArrayList();

        String sql = "SELECT * FROM reserva WHERE dni=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ABMReserva reserva = new ABMReserva();
                reserva.setCantidadpersonas(rs.getInt("personas"));
                reserva.setFechaentrada(rs.getDate("fecha_entrada").toLocalDate());
                reserva.setFechasalida(rs.getDate("fecha_salida").toLocalDate());
                reserva.setPiso(rs.getInt("piso"));
                reserva.setImportetotal(rs.getInt("importe_total"));
                reserva.setDni(rs.getInt("dni"));
                reserva.setNumerohab(rs.getInt("numero"));
                arrayReservas.add(reserva);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR RESERVA");
            ex.printStackTrace();
        }
        return arrayReservas;
    }

    public ArrayList<ABMReserva> buscaReserva(Date fecha_entrada) {

        ArrayList<ABMReserva> arrayReservas = new ArrayList();
        String sql = "SELECT * FROM reserva WHERE fecha_entrada=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDate(1, fecha_entrada);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ABMReserva reserva = new ABMReserva();
                reserva.setCantidadpersonas(rs.getInt("personas"));
                reserva.setFechaentrada(rs.getDate("fecha_entrada").toLocalDate());
                reserva.setFechasalida(rs.getDate("fecha_salida").toLocalDate());
                reserva.setPiso(rs.getInt("piso"));
                reserva.setImportetotal((int) rs.getDouble("importe_total"));
                reserva.setDni(rs.getInt("dni"));
                reserva.setNumerohab(rs.getInt("numero"));

                arrayReservas.add(reserva);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR RESERVA");
        }
        return arrayReservas;
    }

    // Mostrar Habitaciones clasificadas por Tipo de Habitación, y su estado actual (Libre/Ocupada).
    public void informeHuespedes(int dni) {
        ABMHuesped huesped1 = new ABMHuesped();
        String sql = "SELECT  nombre,dni, domicilio, correo, celular  FROM huesped WHERE dni=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                huesped1.setCelular(rs.getInt("celular"));
                huesped1.setCorreo(rs.getString("correo"));
                huesped1.setDni(rs.getInt("dni"));
                huesped1.setDomicilio(rs.getString("domicilio"));
                huesped1.setNombre(rs.getString("nombre"));
            }
            JOptionPane.showMessageDialog(null,
                    "Nombre: " + huesped1.getNombre()
                    + "\nDNI: " + huesped1.getDni()
                    + "\nDomicilio: " + huesped1.getDomicilio()
                    + "\nCorreo: " + huesped1.getCorreo()
                    + "\nCelular: " + huesped1.getCelular());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR RESERVA");
            ex.printStackTrace();
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

    public boolean VerificadorNumeros(String txt) {// SOLO PARA LOS NUMEROS si hay alguna letra entonces el programa  returna true

        for (int i = 0; i < txt.length(); i++) {
            char lector = txt.charAt(i);
            if (lector < '0' || lector > '9') {
                return false;  // FALSO si  lector es menor que 0 o mayor que 9
            }
        }
        return true;
    }

    public boolean VerificadorLetras(String txt) {// SOLO PARA LOS NUMEROS si hay alguna letra entonces el programa  returna true

        for (int i = 0; i < txt.length(); i++) {
            char lector = txt.charAt(i);
            if (!Character.isLetter(lector)) {
                return false; // If any character is not a letter, the method returns false.
            }
        }
        return true; // If all characters are letters, it returns true.

    }
}
