/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.CategoriaBean;
import modelo.TramoBean;

/**
 *
 * @author Teresa Acostha
 */
public class TramoDao {

    Conexion conn;

    public TramoDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(TramoBean tramob, CategoriaBean catbean) {
        String sql = "insert into tramo values (?,?,?,?)";
//        CategoriaBean catbean = tramob.getId_categoria();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, tramob.getId_tramo());
            ps.setDate(2, tramob.getFecha());
            ps.setTime(3, tramob.getHora_salida());
            ps.setInt(4, catbean.getId_categoria());
            ps.executeUpdate();
            System.out.println("SE INSERTO EN TRAMO CON EXITO");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR EN TRAMO!!!!! " + e);
            return false;
        }

    }

    public boolean actualizar(TramoBean tramob, CategoriaBean catbean) {
        String sql = "update tramo set fecha=?,"
                + " hora_salida=?, "
                + "id_categoria=?"
                + " where id_tramo=?;";
//        CategoriaBean catbean = tramob.getId_categoria();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setDate(1, tramob.getFecha());
            ps.setTime(2, tramob.getHora_salida());
            ps.setInt(3, catbean.getId_categoria());
            ps.setInt(4, tramob.getId_tramo());
            ps.executeUpdate();
            System.out.println("SE ACTUALIZO EN TRAMO CON EXITO");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR EN TRAMO!!!!! " + e);
            return false;
        }

    }

    public List<TramoBean> consultarAll() {
        String sql = "select * from tramo";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<TramoBean> lista = new LinkedList<>();
            TramoBean tramob;
            while (rs.next()) {
                CategoriaBean catbean;
                tramob = new TramoBean(rs.getInt("id_tramo"));
                tramob.setFecha(rs.getDate("fecha"));
                tramob.setHora_salida(rs.getTime("hora_salida"));
                catbean = new CategoriaBean(rs.getInt("id_categoria"));
                tramob.setId_categoria(catbean);
                lista.add(tramob);

            }
            System.out.println("CONSULTAR TODO EN TRAMO CORRECTO!!!!!!!!!!" + lista);
            return lista;
        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR TODO EN TRAMO!!!!!!!!!!!" + e);
            return null;
        }

    }

    public List<TramoBean> consultarById(int id_tramo) {
        String sql = "select * from tramo where id_tramo=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_tramo);
            ResultSet rs = ps.executeQuery();
            List<TramoBean> lista = new LinkedList<>();
            TramoBean tramob;
            while (rs.next()) {
                CategoriaBean catbean;
                tramob = new TramoBean(rs.getInt("id_tramo"));
                tramob.setFecha(rs.getDate("fecha"));
                tramob.setHora_salida(rs.getTime("hora_salida"));
                catbean = new CategoriaBean(rs.getInt("id_categoria"));
                tramob.setId_categoria(catbean);
                lista.add(tramob);

            }
            System.out.println("CONSULTAR POR ID EN TRAMO CORRECTO!!!!!!!!" + lista);
            return lista;
        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR EL ID EN TRAMO!!!!!!!!!!" + e);
            return null;
        }

    }

    public boolean eliminar(int id_tramo) {
        String sql = "delete from tramo where id_tramo=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_tramo);
            ps.executeUpdate();
            System.out.println("TRAMO ELIMINADO CON EXITO");
            return true;
        } catch (SQLException e) {
            System.out.println("EL TRAMO NO SE HA ELIMINADO!!!!!!!!!" + e);
            return false;
        }

    }

    public static void main(String[] args) {

        int id_tramo = 1;
//         Date fecha = 2015 - 9 - 8;

    }
}
