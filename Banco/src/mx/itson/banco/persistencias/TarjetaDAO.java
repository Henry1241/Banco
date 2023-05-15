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
import mx.itson.banco.entidades.Tarjeta;

/**
 *  Clase de persistencia para la obtencion de datos de las tarjetas
 * @author Enrique Gonzales Leyva
 *         Jesus Alexis Martan Gallardo
 *         Xylan Rodriguez Robles
 */
public class TarjetaDAO {
     /**
     * Genera una lista de tarjetas para su despliegue en la interfaz
     * @return la lista de tarjetas generada
     */
       public static List<Tarjeta> obtenerTodos(){
       List<Tarjeta> tarjetas = new ArrayList<>();
       try{
           Connection conexion = Conexion.obtener();
           Statement statement = conexion.createStatement();
           ResultSet rs = statement.executeQuery("SELECT * from vw_artista");
           while(rs.next()){
               Tarjeta t = new Tarjeta();
               t.setId(rs.getInt(1));
               t.setNumeroTarjeta(rs.getString(2));
               t.setCvv(rs.getInt(3));
               t.setFechaVencimiento(rs.getDate(4));
               t.setInteres(rs.getDouble(5));


              
               
               tarjetas.add(t);
           }
       } catch(Exception ex){
          System.err.print("Ocurrio un error al obtener usuario: " + ex.getMessage()); 
       }
       return tarjetas;
    }    
}
