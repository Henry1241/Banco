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
import mx.itson.banco.entidades.TarjetaHabiente;

/**
 *
 * @author Xylan
 */
public class TarjetaHabienteDAO {
             public static List<TarjetaHabiente> obtenerTodos(){
       List<TarjetaHabiente> thabientes = new ArrayList<>();
       try{
           Connection conexion = Conexion.obtener();
           Statement statement = conexion.createStatement();
           ResultSet rs = statement.executeQuery("SELECT * from tarjeta_habiente");
           while(rs.next()){
               TarjetaHabiente th = new TarjetaHabiente();
               th.setId(rs.getInt(1));
               th.setNombre(rs.getString(2));
               th.setFechaNacimiento(rs.getDate(3));
               th.setCorreo(rs.getString(4));
               th.setCurp(rs.getString(5));
               th.setRfc(rs.getString(6));
               th.setDireccion(rs.getString(7));



              
               
               thabientes.add(th);
           }
       } catch(Exception ex){
          System.err.print("Ocurrio un error al obtener usuario: " + ex.getMessage()); 
       }
       return thabientes;
    }  
}
