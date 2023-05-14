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
import mx.itson.banco.entidades.Compra;
import mx.itson.banco.enumeradores.TipoMovimiento;

/**
 *
 * @author Xylan
 */
public class CompraDAO {
     public static List<Compra> obtenerTodos(){
       List<Compra> compras = new ArrayList<>();
       try{
           Connection conexion = Conexion.obtener();
           Statement statement = conexion.createStatement();
           ResultSet rs = statement.executeQuery("SELECT * from vw_artista");
           while(rs.next()){
               Compra c = new Compra();
               TipoMovimiento Tipo = TipoMovimiento.valueOf("");
               c.setId(rs.getInt(1));
               c.setFecha(rs.getDate(2));
               c.setCantidadPagar(rs.getDouble(3));
               c.setTipo(Tipo);
              
               
               compras.add(c);
           }
       } catch(Exception ex){
          System.err.print("Ocurrio un error al obtener usuario: " + ex.getMessage()); 
       }
       return compras;
    }    
}
