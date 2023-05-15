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
import mx.itson.banco.entidades.TarjetaHabiente;

/**
 *  Clase de persistencia para la obtencion de datos de los clientes usuarios de tarjetas
 * @author Enrique Gonzales Leyva
 *         Jesus Alexis Martan Gallardo
 *         Xylan Rodriguez Robles
 */
public class TarjetaHabienteDAO {
     /**
     * Genera una lista de usuarios de tarjetas para su despliegue en la interfaz
     * @return la lista de usuarios de tarjetas generada
     */
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
       /**
        * Funcion guardar que permite almacenar la informacion de datos 
        * @param nombre nombre del usuario de la tarjeta
        * @param fechaNacimiento Fecha de nacimiento del usuario de la tarjeta
        * @param curp curp del usuario de la tarjeta
        * @param rfc Registro federal de contribuyente del usuario de la tarjeta
        * @param direccion Direccion al domicilio del usuario de la tarjeta
        * @return El resultado de la funcion guardar
        */
       public static boolean guardar(String nombre, Date fechaNacimiento, String curp, String rfc, String direccion) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO tarjeta_habiente(nombre, fechaNacimiento, curp, rfc, direccion) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setDate(2, (java.sql.Date) fechaNacimiento);
            statement.setString(3, curp);
            statement.setString(4, rfc);
            statement.setString(5, direccion);
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();

        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
}
       /**
        * Funcion para editar una lista de datos ya almacenada en la base de datos
        * @param id Identificador del usuario de la tarjeta
        * @param nombre nombre del usuario de la tarjeta
        * @param fechaNacimiento Fecha de nacimiento del usuario de la tarjeta
        * @param curp curp del usuario de la tarjeta
        * @param rfc Registro federal de contribuyente del usuario de la tarjeta
        * @param direccion Direccion al domicilio del usuario de la tarjeta
        * @return El resultado de la funcion de edicion
        */
        public static boolean editar(int id, String nombre, Date fechaNacimiento, String curp, String rfc, String direccion){
            boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE tarjeta_habiente SET nombre = ?, fechaNacimiento = ?, curp = ?, rfc = ?, direccion = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setDate(2, (java.sql.Date) fechaNacimiento);
            statement.setString(3, curp);
            statement.setString(4, rfc);
            statement.setString(5, direccion);
            statement.setInt(5, id);
            
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
            } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
            
        }
           return false;
}
}
