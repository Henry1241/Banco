/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.banco.persistencias;
import mx.itson.banco.entidades.EstadoCuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Xylan
 */
public class EstadoCuentaDAO {
    private Connection conexion; 
    
    public static EstadoCuenta obtenerPorId(int id) {
        EstadoCuenta estado = new EstadoCuenta();
        try {
           Connection conexion = Conexion.obtener();
           Statement statement = conexion.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT * FROM estado_cuenta WHERE id = ?");
           while (resultSet.next()) {
               estado.setId(resultSet.getInt(1));
           }
           
            if (resultSet.next()) {
                return obtenerPorId(id);
            }
        } catch (SQLException ex) {
             System.err.print("Ocurrio un error al obtener usuario: " + ex.getMessage());
        }
        return null;
    }

    public static List<EstadoCuenta> obtenerTodos() {
        List<EstadoCuenta> estadoCuentas = new ArrayList<>();
        String query = "SELECT * FROM estado_cuenta";
        try {
           Connection conexion = Conexion.obtener();
           Statement statement = conexion.createStatement();
           ResultSet rs = statement.executeQuery("SELECT * from estado_cuenta");
            
            while(rs.next()){
                estadoCuentas.add((EstadoCuenta) obtenerTodos());
            }
        } catch (SQLException ex) {
             System.err.print("Ocurrio un error al obtener usuario: " + ex.getMessage()); 
        }
        return estadoCuentas;
    }

    public void guardar(EstadoCuenta estadoCuenta) {
        String query = "INSERT INTO estado_cuenta (id, saldo_anterior, abono, cargo, inicio_periodo, fecha_corte, saldo_final) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, estadoCuenta.getId());
            statement.setDouble(2, estadoCuenta.getSaldoAnterior());
            statement.setDouble(3, estadoCuenta.getAbono());
            statement.setDouble(4, estadoCuenta.getCargo());
            statement.setDate(5, new java.sql.Date(estadoCuenta.getInicioPeriodo().getTime()));
            statement.setDate(6, new java.sql.Date(estadoCuenta.getFechaCorte().getTime()));
            statement.setDouble(7, estadoCuenta.getSaldoFinal());
            statement.executeUpdate();
        } catch (SQLException ex) {
             System.err.print("Ocurrio un error al obtener usuario: " + ex.getMessage());
        }
    }

}