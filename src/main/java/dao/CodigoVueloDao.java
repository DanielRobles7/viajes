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
import modelo.CodigoVueloBean;

/**
 * CodigoVueloBean codvueb
 *
 * @author Teresa Acostha
 */
public class CodigoVueloDao {

    Conexion conn;

    public CodigoVueloDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(CodigoVueloBean codvueb, ClienteBean clib) {
        String sql = "insert into codigo_vuelo values(?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, codvueb.getId_codigo());
            ps.setInt(2, codvueb.getCodigo_vuelo());
            ps.setInt(3, clib.getId_cliente());
            ps.executeUpdate();
            System.out.println("INSERTAR CORRECTO!!!!!!!! codigo vuelo dao");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR!!!!" + e);
            return false;
        }

    }

    public boolean actualizar(CodigoVueloBean codvueb, ClienteBean clib) {
        String sql = "update codigo_vuelo set codigo_vuelo=?, id_cliente=? where id_codigo=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setInt(1, codvueb.getCodigo_vuelo());
            ps.setInt(2, clib.getId_cliente());
            ps.setInt(3, codvueb.getId_codigo());
            ps.executeUpdate();
            System.out.println("ACTUALIZAR CORRECTO!!!!!!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR!!!!" + e);
            return false;
        }

    }
    
    public List<CodigoVueloBean> consultarAll() {
        /*
        linea 1 = traeme toda la informacion que quiero
        linea 2 = que sea de la tabla tal. (aca va la tabla principal)
        */
        String sql = "select codigo_vuelo.*, cliente.* "
                + "from codigo_vuelo "
                + "inner join cliente on codigo_vuelo.id_cliente = cliente.id_cliente";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<CodigoVueloBean> lista = new LinkedList<>();
            CodigoVueloBean codvueb;
            ClienteBean clientebean;
            while (rs.next()) {
                //--------- Extraccion de los datos de la tabla codigo_vuelo
                codvueb = new CodigoVueloBean(rs.getInt("id_codigo"));
                codvueb.setCodigo_vuelo(rs.getInt("codigo_vuelo"));
                //-------- Extraccion de los datos de la tabla Cliente
                clientebean = new ClienteBean(rs.getInt("id_cliente"));
                clientebean.setNombre(rs.getString("cliente.nombre"));
                //---------- llenado del objeto cliente
                codvueb.setId_cliente(clientebean);
                // llenado de la lista
                lista.add(codvueb);
            }
            System.out.println("CONSULTAR TODO CORRECTO.........."+lista);
            return lista;
        } catch (SQLException e) {
            System.out.println("ERROR EN CONSULTAR TODO.........." + e);
            return null;
        }

    }

    public List<CodigoVueloBean> consultarById(int id_codigo) {
        String sql = "select codigo_vuelo.*, cliente.* "
                + "from codigo_vuelo "
                + "inner join cliente on codigo_vuelo.id_cliente = cliente.id_cliente where id_codigo=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_codigo);
            ResultSet rs = ps.executeQuery();
            List<CodigoVueloBean> lista = new LinkedList<>();
            CodigoVueloBean codvueb;
            ClienteBean clientebean;
            while (rs.next()) {
                //--------- Extraccion de los datos de la tabla codigo_vuelo
                codvueb = new CodigoVueloBean(rs.getInt("id_codigo"));
                codvueb.setCodigo_vuelo(rs.getInt("codigo_vuelo"));
                //-------- Extraccion de los datos de la tabla Cliente
                clientebean = new ClienteBean(rs.getInt("id_cliente"));
                clientebean.setNombre(rs.getString("cliente.nombre"));
                //---------- llenado del objeto cliente
                codvueb.setId_cliente(clientebean);
                // llenado de la lista
                lista.add(codvueb);
            }
            
            System.out.println("CONSULTAR POR ID CORRECTO.........."+lista);
            return lista;
        } catch (SQLException e) {
            System.out.println(e + "ERROR EN CONSULTAR POR ID..........");
            return null;
        }

    }

    public boolean eliminar(int id_codigo) {
        String sql = "delete from codigo_vuelo where id_codigo=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_codigo);
            ps.executeUpdate();

            System.out.println("EL CODIGO SE HA ELIMINADO");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ELIMINAR EL CODIGO!!!!!!!!!" + e);
            return false;
        }

    }

    public static void main(String[] args) {

        int id_codig = 3;
        int codigo_vuelo = 123;
        int id_cliente = 1;
        //-----------------------------------
        Conexion conn = new Conexion();
        CodigoVueloBean cvbean = new CodigoVueloBean(id_codig);
        CodigoVueloDao cvdao = new CodigoVueloDao(conn);
        ClienteBean clibean = new ClienteBean(id_cliente);

        //-----------------------------------
        cvbean.setId_codigo(id_codig);
        cvbean.setCodigo_vuelo(codigo_vuelo);
        clibean.setId_cliente(id_cliente);

        //-----------------------------------
        //System.out.println(cvdao.insertar(cvbean, clibean)); //
//        cvdao.actualizar(cvbean, clibean); actualiza correcto
         System.out.println(cvdao.consultarAll()); ;
//       cvdao.consultarById(id_codig);
//        cvdao.eliminar(id_codig); elimina correcto

    }

}
