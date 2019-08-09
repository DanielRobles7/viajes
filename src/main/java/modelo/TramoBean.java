/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Teresa Acostha
 */
public class TramoBean {

  private int id_tramo ;
   private Date fecha ;
   private Time hora_salida ;
   private CategoriaBean id_categoria;

    public TramoBean(int id_tramo) {
        this.id_tramo = id_tramo;
    }

    public int getId_tramo() {
        return id_tramo;
    }

    public void setId_tramo(int id_tramo) {
        this.id_tramo = id_tramo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }

    public CategoriaBean getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(CategoriaBean id_categoria) {
        this.id_categoria = id_categoria;
    }

   

    
    @Override
    public String toString() {
        return "TramoBean{" + "id_tramo=" + id_tramo + ", fecha=" + fecha + ", hora_salida=" + hora_salida + ", id_categoria=" + id_categoria + '}';
    }
   
   
}
