/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.banco.entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author enri0
 */
public class EstadoCuenta {
    
    private int id;
    private List<Movimiento> movimientos;
    private Tarjeta tarjeta;
    private List<TarjetaHabiente> clientes;
    private Date fecha;
    private Compra tienda;
    private Compra monto;
}
