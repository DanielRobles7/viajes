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
public class CodigoVueloBean {

    private int id_codigo;
    private int codigo_vuelo;
    private ClienteBean id_cliente;

    public CodigoVueloBean(int id_codigo) {
        this.id_codigo = id_codigo;
    }

    public int getId_codigo() {
        return id_codigo;
    }

    public void setId_codigo(int id_codigo) {
        this.id_codigo = id_codigo;
    }

    public int getCodigo_vuelo() {
        return codigo_vuelo;
    }

    public void setCodigo_vuelo(int codigo_vuelo) {
        this.codigo_vuelo = codigo_vuelo;
    }

    public ClienteBean getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(ClienteBean id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "CodigoVueloBean{" + "id_codigo=" + id_codigo + ", codigo_vuelo=" + codigo_vuelo + ", id_cliente=" + id_cliente + '}';
    }
    
    

}
