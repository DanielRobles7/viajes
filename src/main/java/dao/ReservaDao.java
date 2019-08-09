/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Teresa Acostha
 */
public class ReservaDao {
        Conexion conn;

    public ReservaDao(Conexion conn) {
        this.conn = conn;
    }
        
        
    public boolean insertar() {
        String sql = "insert into values()";
        try {
                        PreparedStatement ps = conn.conectar().prepareStatement(sql);

            System.out.println("");
            return true;
        } catch (Exception e) {
            System.out.println("");

            return false;
        }
    }

    public List<> consultarAll() {
        String sql = "select * from";
        try {
                        PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("");
            return lista;
        } catch (Exception e) {
            System.out.println("");
            return null;

        }
    }
    
    public boolean eliminar(int){
    String sql="delete from";
        try {
                        PreparedStatement ps = conn.conectar().prepareStatement(sql);

        } catch (Exception e) {
        }
    }
    
    
    public static void main(String[] args) {

        //-----------------------------
        int id_compania = 0;
        String nombre = "Iberia";
        String codigo_compania = "IB";
        //-----------------------------
        Conexion conn = new Conexion();
        
        //-----------------------------
        //-----------------------------
    }
}
