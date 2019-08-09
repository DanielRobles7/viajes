package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.AereopuertoBean;

public class AeropuertoDao {

    Conexion conn;

    public AeropuertoDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(AereopuertoBean aereo) {
        String sql = "insert into aereopuerto values (?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, aereo.getId_aereopuerto());
            ps.setString(2, aereo.getNombre());
            ps.executeUpdate();

            System.out.println("AEREOPUERTO INSERTADO CON EXITO!!!!!!!!!!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR EN LA TABLA AEREOPUERTO!!!!!!!!!! " + e);
            return false;
        }
    }

    public boolean actualizar(AereopuertoBean aereo) {
        String sql = "update aereopuerto set nombre=? where id_aereopuerto=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setString(1, aereo.getNombre());
            ps.setInt(2, aereo.getId_aereopuerto());
            ps.executeUpdate();

            System.out.println("AEREOPUERTO ACTUALIZADO!!!!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR AEREOPUERTO!!!!!!!!! " + e);
            return false;
        }
    }

    public List<AereopuertoBean> consultarAll() {
        String sql = "select * from aereopuerto";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<AereopuertoBean> lista = new LinkedList<>();
            AereopuertoBean aereo;
            while (rs.next()) {
                aereo = new AereopuertoBean(rs.getInt("id_aereopuerto"));
                aereo.setNombre(rs.getString("nombre"));
                lista.add(aereo);
            }
            System.out.println("CONSULTAR TODO EN TABLA AEREOPUERTO ESTA CORRECTO" + lista);
            return lista;

        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR TODO EN LA TABLA AEREOPUERTO " + e);
            return null;
        }
    }

    public List<AereopuertoBean> consultarById(int id_aereopuerto) {
        String sql = "select * from aereopuerto where id_aereopuerto=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_aereopuerto);
            ResultSet rs = ps.executeQuery();
            List<AereopuertoBean> lista = new LinkedList<>();
            AereopuertoBean aereo;
            while (rs.next()) {
                aereo = new AereopuertoBean(rs.getInt("id_aereopuerto"));
                aereo.setNombre(rs.getString("nombre"));
                lista.add(aereo);
            }
            System.out.println("CONSULTAR BY ID EN TABLA AEREOPUERTO CORRECTO" + lista);
            return lista;

        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR POR ID EN AEREOPUERTO!!!!!!!!!!" + e);
            return null;
        }
    }

    public boolean eliminar(int id_aereopuerto) {
        String sql = "delete from aereopuerto where id_aereopuerto=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_aereopuerto);
            ps.executeUpdate();
            System.out.println("AEREOPUERTO ELIMINADO CON EXITO");
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR AL ELIMINAR EN LA TABLA DE AEREOPUERTO!!!!!!!!!" + e);
            return false;
        }

    }

    public static void main(String[] args) {

        int id_aereopuerto = 2;
        String nombre = "La Aurora";

        Conexion conn = new Conexion();
        AereopuertoBean arebean = new AereopuertoBean(id_aereopuerto);
        AeropuertoDao ardao = new AeropuertoDao(conn);

        arebean.setId_aereopuerto(id_aereopuerto);
        arebean.setNombre(nombre);

        ardao.insertar(arebean);
//        ardao.actualizar(arebean);
//       ardao.consultarAll();
//     ardao.consultarById(id_aereopuerto);
//     ardao.eliminar(id_aereopuerto);
    }
}
                                                                                                                                                

        

    