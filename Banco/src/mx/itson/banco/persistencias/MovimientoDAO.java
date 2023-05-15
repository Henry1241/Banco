/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.banco.persistencias;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.banco.entidades.EstadoCuenta;
import mx.itson.banco.entidades.Movimiento;
import mx.itson.banco.enumeradores.TipoMovimiento;

/**
 *
 * @author Xylan
 */
public class MovimientoDAO {
     public static List<Movimiento> obtenerTodos(){
       List<Movimiento> movimientos = new ArrayList<>();
       try{
           Connection conexion = Conexion.obtener();
           Statement statement = conexion.createStatement();
           ResultSet rs = statement.executeQuery("SELECT * from movimiento");
           while(rs.next()){
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
       } catch(Exception ex){
          System.err.print("Ocurrio un error al obtener usuario: " + ex.getMessage()); 
       }
       return movimientos;
    }    
}

