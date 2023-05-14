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
           ResultSet rs = statement.executeQuery("SELECT * from vw_artista");
           while(rs.next()){
               Movimiento m = new Movimiento();
               m.setId(rs.getInt(1));
               m.setDescripcion(rs.getString(2));
               m.setFecha(rs.getDate(3));
               m.setTipo(TipoMovimiento.valueOf(""));

               movimientos.add(m);
               
           }
       } catch(Exception ex){
          System.err.print("Ocurrio un error al obtener usuario: " + ex.getMessage()); 
       }
       return movimientos;
    }    
}

