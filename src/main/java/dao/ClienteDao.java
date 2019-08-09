/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.ClienteBean;

/**
 *
 * @author Teresa Acostha
 */
public class ClienteDao {

    Conexion conn;

    public ClienteDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(ClienteBean clib) {
        String sql = "insert into cliente values(?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, clib.getId_cliente());
            ps.setString(2, clib.getNombre());
            ps.executeUpdate();

            System.out.println("SE HA INSERTADO CLIENTE CON EXITO!!!!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR EL CLIENTE!!! " + e);
            return false;
        }

    }

    public boolean actualizar(ClienteBean clib) {
        String sql = "update cliente set nombre=? where id_cliente=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setString(1, clib.getNombre());
            ps.setInt(2, clib.getId_cliente());
            ps.executeUpdate();

            System.out.println("SE HA ACTUALIZADO CLIENTE CON EXITO!!!!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR EL CLIENTE!!! " + e);
            return false;
        }

    }

    public List<ClienteBean> consultarAll() {
        String sql = "select * from cliente";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<ClienteBean> lista = new LinkedList<>();
            ClienteBean clib;
            while (rs.next()) {
                clib = new ClienteBean(rs.getInt("id_cliente"));
                clib.setNombre(rs.getString("nombre"));
                lista.add(clib);
            }
            System.out.println("CONSULTAR TODOS LOS CLIENTES CORRECTO " + lista);
            return lista;
        } catch (Exception e) {
            System.out.println("CONSULTAR TODO EN CLIENTES ERRONEO " + e);
            return null;
        }

    }

    public List<ClienteBean> consultarById(int id_cliente) {
        String sql = "select * from cliente where id_cliente=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_cliente);
            ResultSet rs = ps.executeQuery();
            List<ClienteBean> lista = new LinkedList<>();
            ClienteBean clib;
            while (rs.next()) {
                clib = new ClienteBean(rs.getInt("id_cliente"));
                clib.setNombre(rs.getString("nombre"));
                lista.add(clib);
            }
            System.out.println("CONSULTAR POR ID CORRECTO " + lista);
            return lista;
        } catch (SQLException e) {
            System.out.println("CONSULTAR POR ID ERROR " + e);
            return null;
        }

    }

    public boolean eliminar(int id_cliente) {
        String sql = "delete from cliente where id_cliente=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_cliente);
            ps.executeUpdate();
            System.out.println("CLIENTE ELIMINADO CON EXITO!!!!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ELIMINAR EL CLIENTE!!!!!!!!!! " + e);
            return false;
        }

    }

    public static void main(String[] args) {

        int id_cliente = 2;
        String nombre = "Irene";

        Conexion conn = new Conexion();
        ClienteDao clidao = new ClienteDao(conn);
        ClienteBean clibean = new ClienteBean(0);

        clibean.setId_cliente(id_cliente);
        clibean.setNombre(nombre);

//        clidao.insertar(clibean);
        clidao.actualizar(clibean);
//        clidao.consultarAll();
//        clidao.consultarById(id_cliente);
//        clidao.eliminar(id_cliente);

    }

}
