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
 *
 * @author Xylan
 */
public class PeriodoDAO {
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
               p.setCobro(rs.getDouble(3));


              
               
               periodos.add(p);
           }
       } catch(Exception ex){
          System.err.print("Ocurrio un error al obtener usuario: " + ex.getMessage()); 
       }
       return periodos;
    }    
}
