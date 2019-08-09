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
public class VuelosBean {

    private int id_vuelos ;
    private String compania_aerea ;
    private int capacidad ;
    private String categoria ;
    private AereopuertoBean id_aereopuerto;

    public VuelosBean(int id_vuelos) {
        this.id_vuelos = id_vuelos;
    }

    public int getId_vuelos() {
        return id_vuelos;
    }

    public void setId_vuelos(int id_vuelos) {
        this.id_vuelos = id_vuelos;
    }

    public String getCompania_aerea() {
        return compania_aerea;
    }

    public void setCompania_aerea(String compania_aerea) {
        this.compania_aerea = compania_aerea;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public AereopuertoBean getId_aereopuerto() {
        return id_aereopuerto;
    }

    public void setId_aereopuerto(AereopuertoBean id_aereopuerto) {
        this.id_aereopuerto = id_aereopuerto;
    }

    @Override
    public String toString() {
        return "VuelosBean{" + "id_vuelos=" + id_vuelos + ", compania_aerea=" + compania_aerea + ", capacidad=" + capacidad + ", categoria=" + categoria + ", id_aereopuerto=" + id_aereopuerto + '}';
    }
    
    
}
