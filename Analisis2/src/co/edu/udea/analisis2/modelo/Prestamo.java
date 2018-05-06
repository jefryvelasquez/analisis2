/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.analisis2.modelo;

import java.util.Date;

/**
 *
 * @author Telecentro
 */
class Prestamo {
    
    private Date fechaPrestamo;
    private int diasMax;
    private Date fechaDevolucion;
    private double multa;
    private Usuario pretadoA;

    public Prestamo() {
    }

    public Prestamo(Date fechaPrestamo, int diasMax, Date fechaDevolucion, double multa, Usuario pretadoA) {
        this.fechaPrestamo = fechaPrestamo;
        this.diasMax = diasMax;
        this.fechaDevolucion = fechaDevolucion;
        this.multa = multa;
        this.pretadoA = pretadoA;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getDiasMax() {
        return diasMax;
    }

    public void setDiasMax(int diasMax) {
        this.diasMax = diasMax;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public Usuario getPretadoA() {
        return pretadoA;
    }

    public void setPretadoA(Usuario pretadoA) {
        this.pretadoA = pretadoA;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "fechaPrestamo=" + fechaPrestamo + ", diasMax=" + diasMax + ", fechaDevolucion=" + fechaDevolucion + ", multa=" + multa + ", pretadoA=" + pretadoA + '}';
    }
    
    
    
}
