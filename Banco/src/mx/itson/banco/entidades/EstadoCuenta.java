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
    private TarjetaHabiente cliente;
    private double saldoAnterior;
    private double abono;
    private double cargo;
    private Date inicioPeriodo;
    private Date fechaCorte;
    private double saldoFinal;
    private Periodo mes;

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
     * @return the movimientos
     */
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    /**
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    /**
     * @return the tarjeta
     */
    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    /**
     * @param tarjeta the tarjeta to set
     */
    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     * @return the clientes
     */
    public TarjetaHabiente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the clientes to set
     */
    public void setCliente(TarjetaHabiente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the fechaCorte
     */
    public Date getFechaCorte() {
        return fechaCorte;
    }

    /**
     * @param fechaCorte the fechaCorte to set
     */
    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    /**
     * @return the saldoAnterior
     */
    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    /**
     * @param saldoAnterior the saldoAnterior to set
     */
    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    /**
     * @return the abono
     */
    public double getAbono() {
        return abono;
    }

    /**
     * @param abono the abono to set
     */
    public void setAbono(double abono) {
        this.abono = abono;
    }

    /**
     * @return the cargo
     */
    public double getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(double cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the inicioPeriodo
     */
    public Date getInicioPeriodo() {
        return inicioPeriodo;
    }

    /**
     * @param inicioPeriodo the inicioPeriodo to set
     */
    public void setInicioPeriodo(Date inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    /**
     * @return the saldoFinal
     */
    public double getSaldoFinal() {
        return saldoFinal;
    }

    /**
     * @param saldoFinal the saldoFinal to set
     */
    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    /**
     * @return the mes
     */
    public Periodo getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(Periodo mes) {
        this.mes = mes;
    }
}
