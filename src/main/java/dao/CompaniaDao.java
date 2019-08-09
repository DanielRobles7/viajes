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
import modelo.CompaniaBean;

public class CompaniaDao {

    Conexion conn;

    public CompaniaDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(CompaniaBean compab) {
        String sql = "insert into compania_aerea values(?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, compab.getId_compania());
            ps.setString(2, compab.getNombre());
            ps.setString(3, compab.getCodigo_compania());
            ps.executeUpdate();

            System.out.println("EL CODIGO SE HA INSERTADO!!!!!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR EL CODIGO" + e);
            return false;
        }
    }

    public boolean actualizar(CompaniaBean compab) {
        String sql = "update compania_aerea set nombre=?, "
                + "codigo_compania"
                + " where id_compania=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setString(1, compab.getNombre());
            ps.setString(2, compab.getCodigo_compania());
            ps.setInt(3, compab.getId_compania());
            ps.executeUpdate();

            System.out.println("EL CODIGO SE HA ACTUALIZADO!!!!!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR EL CODIGO" + e);
            return false;
        }
    }

    public List<CompaniaBean> consultarAll() {
        String sql = "select * from compania_aerea";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<CompaniaBean> lista = new LinkedList<>();
            CompaniaBean compab;

            while (rs.next()) {
                compab = new CompaniaBean(rs.getInt("id_compania"));
                compab.setNombre(rs.getString("nombre"));
                compab.setCodigo_compania(rs.getString("codigo_compania"));
                lista.add(compab);
            }
            System.out.println("CONSULTAR TODO CORRECTO" + lista);
            return lista;
        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR COMPANIAS" + e);
            return null;

        }
    }

    public List<CompaniaBean> consultarById(int id_compania) {
        String sql = "select * from compania_aerea where id_compania=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_compania);
            ResultSet rs = ps.executeQuery();
            List<CompaniaBean> lista = new LinkedList<>();
            CompaniaBean compab;

            while (rs.next()) {
                compab = new CompaniaBean(rs.getInt("id_compania"));
                compab.setNombre(rs.getString("nombre"));
                compab.setCodigo_compania(rs.getString("codigo_compania"));
                lista.add(compab);

            }
            System.out.println("CONSULTAR POR ID CORRECTO" + lista);
            return lista;
        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR ID DECOMPANIAS" + e);
            return null;

        }
    }

    public boolean eliminar(int id_compania) {
        String sql = "delete from compania_aerea where id_compania=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_compania);
            ps.executeUpdate();
            System.out.println("ELIMINADO");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ELIMINAR" + e);
            return false;
        }
    }

    public static void main(String[] args) {

        //-----------------------------
        int id_compania = 2;
        String nombre = "Avianca";
        String codigo_compania = "AVC";
        //-----------------------------
        Conexion conn = new Conexion();
        CompaniaBean cobean = new CompaniaBean(id_compania);
        CompaniaDao cdao = new CompaniaDao(conn);

        //-----------------------------
        cobean.setCodigo_compania(codigo_compania);
        cobean.setNombre(nombre);
        cobean.setCodigo_compania(codigo_compania);
        //-----------------------------

//        cdao.insertar(cobean);correcto
//        cdao.actualizar(cobean);error
//        cdao.consultarAll();correcto
//        cdao.consultarById(id_compania);correcto
//       cdao.eliminar(id_compania);
    }

}
