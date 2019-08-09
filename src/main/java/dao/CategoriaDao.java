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
import modelo.CategoriaBean;

/**
 *
 * @author Teresa Acostha
 */
public class CategoriaDao {

    Conexion conn;

    public CategoriaDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(CategoriaBean catb) {
        String sql = "insert into categoria values (?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, catb.getId_categoria());
            ps.setString(2, catb.getTipo());
            ps.setDouble(3, catb.getPrecio());
            ps.executeUpdate();
            System.out.println("SE HA INSERTADO LA CATEGORIA.......!!!!!!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR CATEGORIA!!!!! " + e);
            return false;
        }
    }

    public boolean actualizar(CategoriaBean catb) {
        String sql = "update categoria set tipo=?,"
                + "precio=? where id_categoria=?;";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setString(1, catb.getTipo());
            ps.setDouble(2, catb.getPrecio());
            ps.setInt(3, catb.getId_categoria());
            ps.executeUpdate();
            System.out.println("SE HA ACTUALIZADO EN CATEGORIA.......!!!!!!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR CATEGORIA!!!!!! " + e);
            return false;
        }
    }

    public List<CategoriaBean> consultarAll() {
        String sql = "select * from categoria";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<CategoriaBean> lista = new LinkedList<>();
            CategoriaBean catb;
            while (rs.next()) {

                catb = new CategoriaBean(rs.getInt("id_categoria"));
                catb.setTipo(rs.getString("tipo"));
                catb.setPrecio(rs.getDouble("precio"));
                lista.add(catb);
            }
            System.out.println("CONSULTAR TODO EN CATEGORIA CORRECTO!!!!!" + lista);
            return lista;
        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR TODO DE LA TABLA CATEGORIA " + e);
            return null;
        }
    }

    public List<CategoriaBean> consultarById(int id_categoria) {
        String sql = "select * from categoria  where id_categoria=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_categoria);
            ResultSet rs = ps.executeQuery();
            List<CategoriaBean> lista = new LinkedList<>();
            CategoriaBean catb;
            while (rs.next()) {

                catb = new CategoriaBean(rs.getInt("id_categoria"));
                catb.setTipo(rs.getString("tipo"));
                catb.setPrecio(rs.getDouble("precio"));
                lista.add(catb);
            }
            System.out.println("CONSULTAR_BY_ID  EN CATEGORIA CORRECTO!!!!!" + lista);
            return lista;
        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR_BY_ID DE LA TABLA CATEGORIA " + e);
            return null;
        }
    }

    public boolean eliminar(int id_categoria) {
        String sql = "delete from categoria where id_categoria=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_categoria);
            ps.executeUpdate();
            System.out.println("LA CATEGORIA HA SIDO ELIMINADA!!!!!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ELIMINAR LA CATEGORIA!!!! " + e);
            return false;
        }
    }

    public static void main(String[] args) {

        int id_categoria = 3;
        String tipo = "Turista";
        double precio = 2600.00;

        Conexion conn = new Conexion();
        CategoriaDao catdao = new CategoriaDao(conn);
        CategoriaBean catbean = new CategoriaBean(0);

        catbean.setId_categoria(id_categoria);
        catbean.setTipo(tipo);
        catbean.setPrecio(precio);

        catdao.insertar(catbean);
        //catdao.actualizar(catbean);
        // catdao.consultarAll();
        //catdao.consultarById(id_categoria);
        //catdao.eliminar(id_categoria);

    }
}
