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
public class CiudadBean {

    private int id_ciudad;//pk
    private ClienteBean id_cliente;
    private String ciudad_destino;
    private String ciudad_origen;

    public CiudadBean(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public ClienteBean getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(ClienteBean id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCiudad_destino() {
        return ciudad_destino;
    }

    public void setCiudad_destino(String ciudad_destino) {
        this.ciudad_destino = ciudad_destino;
    }

    public String getCiudad_origen() {
        return ciudad_origen;
    }

    public void setCiudad_origen(String ciudad_origen) {
        this.ciudad_origen = ciudad_origen;
    }

    @Override
    public String toString() {
        return "CiudadBean{" + "id_ciudad=" + id_ciudad + ", id_cliente=" + id_cliente + ", ciudad_destino=" + ciudad_destino + ", ciudad_origen=" + ciudad_origen + '}';
    }



   
    
    
}
