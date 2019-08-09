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
import modelo.CiudadBean;
import modelo.ClienteBean;

public class CiudadDao {

    Conexion conn;

    public CiudadDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(CiudadBean ciub, ClienteBean clib) {
        String sql = "insert into ciudad values(?,?,?,?)";
//        ClienteBean clib = ciub.getId_cliente();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, ciub.getId_ciudad());
            ps.setInt(2, clib.getId_cliente());
            ps.setString(3, ciub.getCiudad_destino());
            ps.setString(4, ciub.getCiudad_origen());
            ps.executeUpdate();
            System.out.println("SE INSERTO LA CIUDAD CON EXITO");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR EN TABLA CIUDAD " + e);
            return false;
        }
    }

    public boolean actualizar(CiudadBean ciub, ClienteBean clib) {
        String sql = "update ciudad set id_cliente=?,"
                + "ciudad_destino=?,"
                + "ciudad_origen=?"
                + "where id_ciudad=?;";

//        ClienteBean clib = ciub.getId_cliente();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setInt(1, clib.getId_cliente());
            ps.setString(2, ciub.getCiudad_destino());
            ps.setString(3, ciub.getCiudad_origen());
            ps.setInt(4, ciub.getId_ciudad());
            ps.executeUpdate();
            System.out.println("SE ACTUALIZO LA CIUDAD CON EXITO");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR EN TABLA CIUDAD " + e);
            return false;
        }
    }

    public List<CiudadBean> consultarAll() {
        String sql = "select * from ciudad";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<CiudadBean> lista = new LinkedList<>();
            CiudadBean ciub;

            while (rs.next()) {
                ClienteBean clientebean;
                ciub = new CiudadBean(rs.getInt("id_ciudad"));
                clientebean = new ClienteBean(rs.getInt("id_cliente"));
                ciub.setCiudad_destino(rs.getString("ciudad_destino"));
                ciub.setCiudad_origen(rs.getString("ciudad_origen"));
                ciub.setId_cliente(clientebean);
                lista.add(ciub);
            }
            System.out.println("CONSULTAR TODO EN CIUDAD CORRECTO" + lista);
            return lista;
        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR TODO EN CIUDAD!!!!!!!!" + e);
            return null;
        }

    }

    public List<CiudadBean> consultarById(int id_ciudad) {
        String sql = "select * from ciudad where id_ciudad=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_ciudad);
            ResultSet rs = ps.executeQuery();
            List<CiudadBean> lista = new LinkedList<>();
            CiudadBean ciub;

            while (rs.next()) {
                ClienteBean clientebean;
                ciub = new CiudadBean(rs.getInt("id_ciudad"));
                clientebean = new ClienteBean(rs.getInt("id_cliente"));
                ciub.setCiudad_destino(rs.getString("ciudad_destino"));
                ciub.setCiudad_origen(rs.getString("ciudad_origen"));
                ciub.setId_cliente(clientebean);
                lista.add(ciub);
            }
            System.out.println("CONSULTAR POR ID EN CIUDAD CORRECTO" + lista);
            return lista;
        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR POR ID EN CIUDAD!!!!!!!!" + e);
            return null;
        }

    }

    public boolean eliminar(int id_ciudad) {
        String sql = "delete from ciudad where id_ciudad=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_ciudad);
            ps.executeUpdate();
            System.out.println("CIUDAD ELIMINADA CON EXITO");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ELIMINAR CIUDAD!!!!!!" + e);
            return false;
        }

    }

    public static void main(String[] args) {

        int id_ciudad = 2;
        int id_cliente = 1;
        String ciudad_destino = "Medellin";
        String ciudad_origen = "Rio de Janeiro";

        Conexion conn = new Conexion();
        ClienteBean clienteb = new ClienteBean(0);
//        ClienteDao clientedao = new ClienteDao(conn);
        CiudadBean ciudadbean = new CiudadBean(0);
        CiudadDao ciudadao = new CiudadDao(conn);

        ciudadbean.setId_ciudad(id_ciudad);
        clienteb.setId_cliente(id_cliente);
        ciudadbean.setCiudad_destino(ciudad_destino);
        ciudadbean.setCiudad_origen(ciudad_origen);

       ciudadao.insertar(ciudadbean, clienteb);//INSERTAR CORRECTO
//        ciudadao.actualizar(ciudadbean, clienteb);//actualiza correcto
//        ciudadao.consultarAll();//CONSULTAR TODO ENVIA NOMBRE NULO
//        ciudadao.consultarById(id_ciudad);//CONSULTAR POR ID ENVIA NOMBRE NULO
//        ciudadao.eliminar(id_ciudad); CIUDAD ELIMINA CORRECTO

    }
}
