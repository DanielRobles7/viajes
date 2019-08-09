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
public class CompaniaBean {
    private int id_compania;
    private String nombre;
    private String codigo_compania;

    public CompaniaBean(int id_compania) {
        this.id_compania = id_compania;
    }

    public int getId_compania() {
        return id_compania;
    }

    public void setId_compania(int id_compania) {
        this.id_compania = id_compania;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo_compania() {
        return codigo_compania;
    }

    public void setCodigo_compania(String codigo_compania) {
        this.codigo_compania = codigo_compania;
    }

    @Override
    public String toString() {
        return "CompaniaBean{" + "id_compania=" + id_compania + ", nombre=" + nombre + ", codigo_compania=" + codigo_compania + '}';
    }
    
    
}
