/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.banco.entidades;

import java.util.List;

/**
 *
 * @author enri0
 */
public class Movimiento {
    
    private int id;
    private List<EstadoCuenta> cuentas;

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
     * @return the cuentas
     */
    public List<EstadoCuenta> getCuentas() {
        return cuentas;
    }

    /**
     * @param cuentas the cuentas to set
     */
    public void setCuentas(List<EstadoCuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
