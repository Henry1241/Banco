/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.banco.entidades;

import java.util.Date;
import mx.itson.banco.enumeradores.TipoMovimiento;

/**
 *
 * @author enri0
 */
public class Compra {
 
    private int id;
    private Date fecha;
    private String nombreTienda;
    private double cantidadPagar;
    private TipoMovimiento tipo;
}
