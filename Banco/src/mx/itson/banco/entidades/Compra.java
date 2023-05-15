/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.banco.entidades;

import java.util.Date;
import mx.itson.banco.enumeradores.TipoMovimiento;

/**
 * Entidad de clase de compra
 * @author Enrique Gonzales Leyva
 *         Jesus Alexis Martan Gallardo
 *         Xylan Rodriguez Robles
 */
public class Compra {
 
    private int id;
    private Date fecha;
    private String nombreTienda;
    private double cantidadPagar;
    private TipoMovimiento tipo;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the nombreTienda
     */
    public String getNombreTienda() {
        return nombreTienda;
    }

    /**
     * @param nombreTienda the nombreTienda to set
     */
    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    /**
     * @return the cantidadPagar
     */
    public double getCantidadPagar() {
        return cantidadPagar;
    }

    /**
     * @param cantidadPagar the cantidadPagar to set
     */
    public void setCantidadPagar(double cantidadPagar) {
        this.cantidadPagar = cantidadPagar;
    }

    /**
     * @return the tipo
     */
    public TipoMovimiento getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }
    
}
