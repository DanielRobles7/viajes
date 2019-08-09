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
public class AereopuertoBean {
   
    private int id_aereopuerto;
    private String nombre;

    public AereopuertoBean(int id_aereopuerto) {
        this.id_aereopuerto = id_aereopuerto;
    }

    public int getId_aereopuerto() {
        return id_aereopuerto;
    }

    public void setId_aereopuerto(int id_aereopuerto) {
        this.id_aereopuerto = id_aereopuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "AereopuertoBean{" + "id_aereopuerto=" + id_aereopuerto + ", nombre=" + nombre + '}';
    }
    
    
    
}
