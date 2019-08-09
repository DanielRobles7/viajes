/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Teresa Acostha
 */
public class EscalaBean {
    private int id_escala;
    private TramoBean id_tramo;

    public EscalaBean(int id_escala) {
        this.id_escala = id_escala;
    }

    public int getId_escala() {
        return id_escala;
    }

    public void setId_escala(int id_escala) {
        this.id_escala = id_escala;
    }

    public TramoBean getId_tramo() {
        return id_tramo;
    }

    public void setId_tramo(TramoBean id_tramo) {
        this.id_tramo = id_tramo;
    }

    @Override
    public String toString() {
        return "EscalaBean{" + "id_escala=" + id_escala + ", id_tramo=" + id_tramo + '}';
    }
    
    
}
