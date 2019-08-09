/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Teresa Acostha
 */
public class ReservaBean {

    private int id_reserva;
    private ClienteBean id_cliente;
    private Date fecha_emision;
    private int asiento_reservado;
    private TramoBean id_tramo;
    private CategoriaBean id_categoria;

    public ReservaBean(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public ClienteBean getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(ClienteBean id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public int getAsiento_reservado() {
        return asiento_reservado;
    }

    public void setAsiento_reservado(int asiento_reservado) {
        this.asiento_reservado = asiento_reservado;
    }

    public TramoBean getId_tramo() {
        return id_tramo;
    }

    public void setId_tramo(TramoBean id_tramo) {
        this.id_tramo = id_tramo;
    }

    public CategoriaBean getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(CategoriaBean id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public String toString() {
        return "ReservaBean{" + "id_reserva=" + id_reserva + ", id_cliente=" + id_cliente + ", fecha_emision=" + fecha_emision + ", asiento_reservado=" + asiento_reservado + ", id_tramo=" + id_tramo + ", id_categoria=" + id_categoria + '}';
    }
    
    
}
