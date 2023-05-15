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
import mx.itson.banco.entidades.Periodo;


/**
 *  Clase de persistencia para la obtencion de datos de los periodos de pago
 * @author Enrique Gonzales Leyva
 *         Jesus Alexis Martan Gallardo
 *         Xylan Rodriguez Robles
 */
public class PeriodoDAO {
     /**
     * Genera una lista de periodos de pago para su despliegue en la interfaz
     * @return la lista de periodos de pago generada
     */
       public static List<Periodo> obtenerTodos(){
       List<Periodo> periodos = new ArrayList<>();
       try{
           Connection conexion = Conexion.obtener();
           Statement statement = conexion.createStatement();
           ResultSet rs = statement.executeQuery("SELECT * from vw_artista");
           while(rs.next()){
               Periodo p = new Periodo();
               p.setId(rs.getInt(1));
               p.setMes(rs.getString(2));
 
               periodos.add(p);
           }
       } catch(Exception ex){
          System.err.print("Ocurrio un error al obtener usuario: " + ex.getMessage()); 
       }
       return periodos;
    }    
}