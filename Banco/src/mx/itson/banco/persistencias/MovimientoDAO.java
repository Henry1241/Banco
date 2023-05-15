/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.banco.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.itson.banco.entidades.EstadoCuenta;
import mx.itson.banco.entidades.Movimiento;
import mx.itson.banco.enumeradores.TipoMovimiento;

/**
 * Clase de persistencia para la obtencion de datos de los movimientos de cuenta
 * @author Enrique Gonzales Leyva
 *         Jesus Alexis Martan Gallardo
 *         Xylan Rodriguez Robles
 */
public class MovimientoDAO {
    
    /**
     * Genera una lista de movimientos para su despliegue en la interfaz
     * @return la lista de movimientos generada
     */
    public static List<Movimiento> obtenerTodos() {
        List<Movimiento> movimientos = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from movimiento");
            while (rs.next()) {
                Movimiento m = new Movimiento();
                TipoMovimiento t = TipoMovimiento.ABONO;
                List<EstadoCuenta> cuentas = new ArrayList<>();
                m.setId(rs.getInt(1));
                m.setDescripcion(rs.getString(2));
                m.setCargo(rs.getDouble(3));
                m.setFecha(rs.getDate(4));
                m.setTipo(t);
                m.setIntereses(rs.getDouble(7));

                movimientos.add(m);

            }
        } catch (Exception ex) {
            System.err.print("Ocurrio un error al obtener usuario: " + ex.getMessage());
        }
        return movimientos;
    }
    /**
     * Funcion guardar que permite almacenar la informacion de datos 
     * @param descripcion La descripcion del movimiento
     * @param cargo La cantidad de dinero cargada en el movimiento
     * @param fecha La fecha de realizacion del movimiento
     * @param cuenta La cuenta que efectuo el movimiento bancario
     * @param tipoMovimiento El tipo de movimiento efectuado
     * @return El resultado de la funcion guardar
     */
    public static boolean guardar(String descripcion, double cargo, Date fecha, EstadoCuenta cuenta, TipoMovimiento tipoMovimiento) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO movimiento(descripcion, cargo, fecha, tipoMovimiento) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, descripcion);
            statement.setDouble(2, cargo);
            statement.setDate(3, (java.sql.Date) fecha);
            statement.setObject(4, cuenta);
            statement.setObject(5, tipoMovimiento);
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();

        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
}
