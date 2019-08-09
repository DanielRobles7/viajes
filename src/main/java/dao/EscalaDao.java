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
import modelo.EscalaBean;
import modelo.TramoBean;

/**
 *
 * @author Teresa Acostha
 */
public class EscalaDao {

    Conexion conn;

    public EscalaDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(EscalaBean esb, TramoBean trb) {
        String sql = "insert into escala values(?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, esb.getId_escala());
            ps.setInt(2, trb.getId_tramo());
            ps.executeUpdate();

            System.out.println("SE INSERTO CON EXITO");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR" + e);

            return false;
        }
    }

    public boolean actualizar(EscalaBean esb, TramoBean trb) {
        String sql = "update escala set id_tramo where id_escala=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, trb.getId_tramo());
            ps.setInt(2, esb.getId_escala());
            ps.executeUpdate();

            System.out.println("SE ACTUALIZO CON EXITO");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR" + e);

            return false;
        }
    }

    public List<EscalaBean> consultarAll() {
        String sql = "select * from escala";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<EscalaBean> lista = new LinkedList<>();
            EscalaBean ecb;
            while (rs.next()) {
                TramoBean tramo;
                ecb = new EscalaBean(rs.getInt("id_escala"));
                tramo = new TramoBean(rs.getInt("id_tramo"));
                ecb.setId_tramo(tramo);
                lista.add(ecb);
            }
            System.out.println("CONSULTAR TODO CORRECTO" + lista);
            return lista;
        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR TODO");
            return null;

        }
    }

    public List<EscalaBean> consultarById(int id_escala) {
        String sql = "select * from escala where id_escala=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_escala);
            ResultSet rs = ps.executeQuery();
            List<EscalaBean> lista = new LinkedList<>();
            EscalaBean ecb;
            while (rs.next()) {
                TramoBean tramo;
                ecb = new EscalaBean(rs.getInt("id_escala"));
                tramo = new TramoBean(rs.getInt("id_tramo"));
                ecb.setId_tramo(tramo);
                lista.add(ecb);
            }
            System.out.println("CONSULTAR TODO CORRECTO" + lista);
            return lista;
        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR TODO");
            return null;

        }
    }

    public boolean eliminar(int id_escala) {
        String sql = "delete from escala where id_escala=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_escala);
            ps.executeUpdate();
            System.out.println("LA ESCALA SE ELIMINO!!!!!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ELIMINAR" + e);
            return false;
        }
    }

    public static void main(String[] args) {

        //-----------------------------
        int id_escala = 1;
        int id_tramo = 2;
        //-----------------------------

        Conexion conn = new Conexion();
        EscalaBean esbean = new EscalaBean(id_escala);
        TramoBean tbean = new TramoBean(id_tramo);
        EscalaDao esdao = new EscalaDao(conn);

        //-----------------------------
        esbean.setId_escala(id_escala);
        esbean.setId_tramo(tbean);

        //-----------------------------
//        esdao.insertar(esbean, tbean);corecto
//   esdao.actualizar(esbean, tbean);
//       esdao.consultarAll();
//        esdao.consultarById(id_escala);
        esdao.eliminar(id_escala);

    }
}
